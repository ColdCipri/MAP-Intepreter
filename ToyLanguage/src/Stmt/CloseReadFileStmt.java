package Stmt;

import java.io.IOException;

import Domain.IPrgState;
import Domain.PrgState;
import Exceptions.InvalidAddressException;
import Exceptions.InvalidFileException;
import Exceptions.InvalidSignException;
import Exceptions.InvalidSymbolException;
import Exceptions.NullAdressException;
import Exceptions.OperandException;
import Exceptions.ZeroDevisionException;
import Exp.IExp;

public class CloseReadFileStmt implements IStmt {
	IExp exp;
	public CloseReadFileStmt(IExp exp) {
		this.exp = exp;
	}
	@Override
	public IPrgState execute(PrgState state) throws InvalidSignException, InvalidFileException, IOException, OperandException, ZeroDevisionException, InvalidSymbolException, InvalidAddressException, NullAdressException {
		
		int fid = exp.resolve(state.symtbl, state.heap);	
		state.fileTbl.getFile(fid).close();
		state.fileTbl.removeFile(fid);
		
		return null;
	}
	
	@Override
	public String toString() {
		
		return "CloseReadFile( " + exp.toString() + ")";
	}

}
