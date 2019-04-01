package Stmt;

import java.io.BufferedReader;
import java.io.IOException;

import Domain.IPrgState;
import Domain.PrgState;
import Exceptions.DuplicateSymbolException;
import Exceptions.InvalidAddressException;
import Exceptions.InvalidFileException;
import Exceptions.InvalidSignException;
import Exceptions.InvalidSymbolException;
import Exceptions.NullAdressException;
import Exceptions.OperandException;
import Exceptions.ZeroDevisionException;
import Exp.IExp;

public class ReadFileStmt implements IStmt {

	IExp exp;
	String symbol;
	public ReadFileStmt(IExp exp, String symbol) {
		this.exp = exp;
		this.symbol = symbol;
	}
	
	@Override
	public IPrgState execute(PrgState state) throws InvalidSignException, InvalidFileException, IOException, DuplicateSymbolException, 
													InvalidSymbolException, InvalidAddressException, NullAdressException, OperandException, ZeroDevisionException {
		
		int fid = exp.resolve(state.symtbl, state.heap);
		BufferedReader r = state.fileTbl.getFile(fid);
		int value = 0;
		try{
			String l = r.readLine();
			value = Integer.parseInt(l);	
		} catch (NumberFormatException  e) {
			value = 0;
		}
		state.symtbl.addSymbol(symbol, value);
		return state;
	}
	@Override
	public String toString() {
		return "ReadFileStatement(" + exp.toString() + ", \"" + symbol + "\")";
	}
}
