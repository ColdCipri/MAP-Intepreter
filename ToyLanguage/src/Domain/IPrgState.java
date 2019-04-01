package Domain;

import java.io.IOException;
import java.util.ArrayList;

import Exceptions.*;
import Stmt.IStmt;

public interface IPrgState  {
	public void executeNextStep()
			throws InvalidStateException, InvalidSignException, DuplicateSymbolException, InvalidFileException,
			IOException, DuplicateFileException, InvalidSymbolException, InvalidAddressException, NullAdressException, OperandException, ZeroDevisionException;
	public String toString();
	public ArrayList<Integer> getOutput();
	public boolean isDone();
	public IHeap getHeap();
	public ISymbTbl getSymTable();
	public IFileTbl getFileTbl();
	void addStatement(IStmt s);
}

