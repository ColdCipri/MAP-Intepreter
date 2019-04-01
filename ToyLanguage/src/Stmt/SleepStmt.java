package Stmt;

import java.io.IOException;

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
import Exp.ArithExp;
import Exp.ConstExp;
import Exp.IExp;

public class SleepStmt implements IStmt{
	private IExp exp;
	public SleepStmt(IExp exp) {
		this.setExp(exp);
	}
	
	 public IExp getExp() {
        return exp;
    }

    public void setExp(IExp exp) {
        this.exp = exp;
    }

	@Override
	public IPrgState execute(PrgState state) throws InvalidSignException, DuplicateSymbolException,
			InvalidFileException, IOException, DuplicateFileException, InvalidSymbolException, InvalidAddressException,
			NullAdressException, OperandException, ZeroDevisionException {
		if (getExp().isTrue(state.symtbl, state.heap)) {
			this.setExp(new ArithExp('-', 
									this.getExp(), 
									new ConstExp(1)));
			
			state.myStack.push(this);
			}
		return state;
	}
	
	public String toString() {
        return "sleep ( "+ exp.toString() +" )";
    }

}
