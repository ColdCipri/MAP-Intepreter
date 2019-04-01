package Stmt;

import Domain.IPrgState;
import Domain.PrgState;

public class CompStmt implements IStmt{
	private IStmt first;
	private IStmt snd;
	
	public CompStmt(IStmt first, IStmt snd){
		this.setStatement1(first);
		this.setStatement2(snd);
	}
	
	@Override
	public IPrgState execute(PrgState state){
		state.myStack.push(snd);
		state.myStack.push(first);
		return state;
	}
	
	public String toString() {
    	return ""+ first.toString() +";" + snd.toString() +"";
    }
		
	public IStmt getStatement1() {
		return first;
	}
		 
	public IStmt getStatement2() {
		return snd;
	}
		 
	public void setStatement1(IStmt first) {
		this.first = first;
	}
	
	public void setStatement2(IStmt snd) {
		this.snd = snd;
	}
}