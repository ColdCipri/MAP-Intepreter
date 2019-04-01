package Stmt;

import Domain.IPrgState;
import Domain.PrgState;
import Exceptions.DuplicateSymbolException;
import Exceptions.InvalidAddressException;
import Exceptions.InvalidSignException;
import Exceptions.InvalidSymbolException;
import Exceptions.NullAdressException;
import Exceptions.OperandException;
import Exceptions.ZeroDevisionException;
import Exp.IExp;

public class HeapAllocationStmt implements IStmt{
	String varName;
	IExp exp;
	public HeapAllocationStmt(String varName, IExp exp) {
		this.varName = varName;
		this.exp = exp;
	}
	
	@Override
	public IPrgState execute(PrgState state) throws InvalidSignException, DuplicateSymbolException, InvalidSymbolException, InvalidAddressException, NullAdressException, OperandException, ZeroDevisionException { 
		int value = exp.resolve(state.symtbl, state.heap);
		
		int address = state.heap.addItem(value);
		
		state.symtbl.addSymbol(varName, address);
		return state;
	}
	
	@Override
	public String toString() {
		return "new( " + varName + ", " + exp.toString() + ")";
	}
 }
