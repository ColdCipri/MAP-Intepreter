package Controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import Domain.*;
import Exceptions.*;
import Exp.ConstExp;
import Repository.IRepo;
import Stmt.CloseReadFileStmt;


public class Controller implements IController{

	IRepo repo;
	public PrintCallBack callback;
	public Controller(IRepo r ) {
		repo = r;
	}
	
	
	
	public PrgState getNextState(IPrgState s) throws InvalidStateException, InvalidSignException, 
						DuplicateSymbolException, InvalidFileException, IOException, DuplicateFileException, OperandException, 
						ZeroDevisionException, InvalidSymbolException, InvalidAddressException, NullAdressException 
		{
			PrgState st = new PrgState((PrgState) s);
			repo.addPrgState(st);
			st.executeNextStep();
			return st;
		}
	
	@Override
	public void executeAllSteps() {
		//empty the repo first 
		repo.clean();
		//get first program state in repo
		IPrgState s = repo.getPrgState(0);
		//log state of the program to the file
		//print everything to the screen
		try {
			repo.logPrgState();
			callback.printCallBack(s.toString());
			
			while (!s.isDone())
			{
				try {
					s = this.getNextState(s);
				} catch (OperandException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ZeroDevisionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				s.getHeap().setContent(
						conservativeGarbageCollector(s.getSymTable().getContent().values(), s.getHeap().getContent()));
				repo.logPrgState();
				callback.printCallBack(s.toString());

			}
			
		} catch (InvalidAddressException | IOException | InvalidStateException | InvalidSignException
				| DuplicateSymbolException | InvalidFileException | DuplicateFileException | InvalidSymbolException
				| NullAdressException ex) {
			callback.printCallBack(ex.getLocalizedMessage());
		}
		finally {
			for(int fd : s.getSymTable().getContent().values()) {
				if (s.getFileTbl().contains(fd)) {
					try {
						s.addStatement(new CloseReadFileStmt(new ConstExp(fd)));					
						try {
							s.executeNextStep();
						} catch (OperandException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ZeroDevisionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						callback.printCallBack("Closed file with file descriptor: " + fd);
					} catch (InvalidStateException | InvalidSignException | DuplicateSymbolException
							| InvalidFileException | IOException | DuplicateFileException | InvalidSymbolException
							| InvalidAddressException | NullAdressException e) {

						callback.printCallBack(e.getLocalizedMessage());
					}
				}
			}
			callback.printCallBack(s.getFileTbl().toString());
		}
	}

	@Override
	public void nextStep() throws IOException, InvalidStateException, InvalidSignException, DuplicateSymbolException,
			InvalidFileException, DuplicateFileException, OperandException, ZeroDevisionException, InvalidSymbolException, InvalidAddressException, NullAdressException 
	{
		IPrgState s = repo.getPrgState(0);
		if (!s.isDone()) 
		{
			s = this.getNextState(s);
			repo.logPrgState();
		}
		
	}
		
	
	@Override
	public HashMap<Integer, Integer> conservativeGarbageCollector(Collection<Integer> symTableValues,
			HashMap<Integer, Integer> heap) {
 		for (Integer address : heap.keySet())
			if (!symTableValues.contains(address))
				heap.remove(address);
		return heap;
 	}
}
