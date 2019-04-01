package Stmt;

import Domain.IPrgState;
import Domain.PrgState;
import Exceptions.DuplicateFileException;
import Exceptions.DuplicateSymbolException;
import Exceptions.InvalidAddressException;
import Exceptions.InvalidFileException;
import Exceptions.InvalidSignException;
import Exceptions.InvalidSymbolException;
import Exceptions.NullAdressException;
import Exceptions.OperandException;
import Exceptions.ZeroDevisionException;
import Exp.IExp;

public class HeapWritingStmt implements IStmt{
	String varName;
	IExp val;
	
	public HeapWritingStmt(String varName, IExp val) {
		this.varName = varName;
		this.val = val;
	}
	
	@Override
	public IPrgState execute(PrgState state) throws InvalidSignException, DuplicateSymbolException,
			InvalidSymbolException, InvalidAddressException, InvalidFileException, NullAdressException, DuplicateFileException, 
			OperandException, ZeroDevisionException {
		int value = val.resolve(state.symtbl, state.heap);
 		int address = state.symtbl.getValueOf(varName);
		state.heap.updateValue(address, value);
		return state;
	}

	@Override
	public String toString() {
		return "wH( " + varName + ", " + val.toString() + ")";
	}
}
