package Stmt;

import Domain.IPrgState;
import Domain.PrgState;
import Exp.IExp;
import Exceptions.DuplicateSymbolException;
import Exceptions.InvalidAddressException;
import Exceptions.InvalidSignException;
import Exceptions.InvalidSymbolException;
import Exceptions.NullAdressException;
import Exceptions.OperandException;
import Exceptions.ZeroDevisionException;

public class AssignStmt implements IStmt{
	private String id;
	private IExp exp;
	public AssignStmt(String id, IExp exp) {
		this.id=id;
		this.setExp(exp);
	}
	
	@Override
	public IPrgState execute (PrgState state) throws DuplicateSymbolException, InvalidSignException, InvalidSymbolException, 
									InvalidAddressException, NullAdressException, OperandException, ZeroDevisionException  {
		
			state.symtbl.addSymbol(id, this.exp.resolve(state.symtbl, state.heap));
		
		return state;
	}
	
	public IExp getExp() {
		return this.exp;
	}
	
	public void setExp(IExp exp) {
		this.exp = exp;		
	}

	 public String toString() {
	    	return id + " = " + exp.toString() +" ";
	    }
}