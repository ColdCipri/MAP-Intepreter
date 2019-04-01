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
import Exp.IExp;

public class WhileStmt implements IStmt{
	private IExp exp;
	private IStmt stmtToExec;

	public WhileStmt(IExp exp, IStmt stmtToExec) {
		this.exp = exp;
		this.stmtToExec = stmtToExec;
	}
	
	@Override
	public IPrgState execute(PrgState state) throws InvalidSignException, DuplicateSymbolException,
			InvalidFileException, IOException, DuplicateFileException, InvalidSymbolException, InvalidAddressException,
			NullAdressException, OperandException, ZeroDevisionException {
		if (exp.isTrue(state.symtbl, state.heap)) {
			state.myStack.push(this);
			state.myStack.push(stmtToExec);
		}
		return state;
	}

	public IExp getExp() {
		return this.exp;
	}
	
	public void setExp(IExp exp) {
		this.exp = exp;
	}
	
	public String toString() {
		return "While ( " + exp.toString()	+ " do: " + stmtToExec.toString()	+ " ";
	}
}
