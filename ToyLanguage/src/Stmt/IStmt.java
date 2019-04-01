package Stmt;

import java.io.IOException;

import Domain.IPrgState;
import Domain.PrgState;
import Exceptions.*;

public interface IStmt {
	
	public IPrgState execute(PrgState state) throws InvalidSignException, DuplicateSymbolException, InvalidFileException, IOException,
	DuplicateFileException, InvalidSymbolException, InvalidAddressException, NullAdressException, OperandException, ZeroDevisionException;
}




