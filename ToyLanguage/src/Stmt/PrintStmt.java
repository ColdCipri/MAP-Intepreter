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

public class PrintStmt implements IStmt{
	private IExp exp;
    public PrintStmt(IExp exp){
        this.setExp(exp);
    }
    
    @Override
    public IPrgState execute(PrgState state) throws InvalidSymbolException, InvalidAddressException, NullAdressException, OperandException, ZeroDevisionException, InvalidSignException {

        state.output.addOutput(getExp().resolve(state.symtbl, state.heap));
        return state;
    }
    
    public String toString() {
    	return "Print( " + exp.toString() +  " )";
    }

    public IExp getExp() {
        return exp;
    }

    public void setExp(IExp exp) {
        this.exp = exp;
    }
	
}