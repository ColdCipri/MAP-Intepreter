package Stmt;

import Domain.IPrgState;
import Domain.PrgState;
import Exceptions.InvalidAddressException;
import Exceptions.InvalidSignException;
import Exceptions.InvalidSymbolException;
import Exceptions.NullAdressException;
import Exceptions.OperandException;
import Exceptions.ZeroDevisionException;
import Exp.IExp;

public class IfStmt implements IStmt{
	private IExp exp;
	private IStmt thenS;
	private IStmt elseS;
	 
	public IfStmt(IExp e, IStmt t, IStmt f) {
		this.setExp(e); 
		this.setTrue(t);
		this.setFalse(f);
	}

	@Override
    public IPrgState execute(PrgState state) throws OperandException, ZeroDevisionException, InvalidSymbolException, InvalidSignException, InvalidAddressException, NullAdressException{
        if(getExp().isTrue(state.symtbl, state.heap)){
            state.myStack.push(thenS);
        }
        else{
        	state.myStack.push(elseS);
        }
        return state;
    }
	
	public IExp getExp() {
        return exp;
    }

    public void setExp(IExp exp) {
        this.exp = exp;
    }

    public IStmt getTrue() {
        return thenS;
    }

    public void setTrue(IStmt thenS) {
        this.thenS = thenS;
    }

    public IStmt getFalse() {
        return elseS;
    }

    public void setFalse(IStmt elseS) {
        this.elseS = elseS;
    }
    
    public String toString() {
        return "If ( "+ exp.toString() +", then: "+thenS.toString() +"else:" + elseS.toString() +")";
    }
	
}