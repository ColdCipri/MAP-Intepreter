package Stmt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import Domain.IPrgState;
import Domain.PrgState;
import Exceptions.DuplicateFileException;
import Exceptions.DuplicateSymbolException;


public class OpenReadFileStmt implements IStmt {

	String fileName;
	String symbol;
	int fd; //file descriptor
	public OpenReadFileStmt(String fileName,String symbol) {
		this.fileName = fileName;
		this.symbol = symbol;
		
	}
	
	@Override
	public IPrgState execute(PrgState state) throws FileNotFoundException, DuplicateFileException, DuplicateSymbolException {
		fd = state.fileTbl.count();
		
		state.fileTbl.addFile(fd, new BufferedReader(new FileReader(new File(fileName))));
		state.symtbl.addSymbol(symbol,fd);
		
		return state;
	}
	
	@Override
	public String toString() {
		return "OpenReadFileStmt(" + symbol + ", \"" + fileName + "\")";
	}

}
