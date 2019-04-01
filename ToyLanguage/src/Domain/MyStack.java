package Domain;

import java.util.Stack;

import Stmt.IStmt;

public class MyStack implements MyIStack{
	private Stack<IStmt> stack;
	

	public MyStack(){
        stack = new Stack<>();
    }
	
	public MyStack(MyStack s) {
    	stack = new Stack<>();
    	for(IStmt st: s.stack)
    		stack.push(st);
    }
	
	public Stack<IStmt> getStack() {
        return stack;
    }

    public void setStack(Stack<IStmt> stack) {
        this.stack = stack;
    }
	
    @Override
	public void push(IStmt t) {
		this.stack.push(t);
	}

    @Override
	public IStmt pop() {
		return this.stack.pop();
	}
	
    @Override
	public boolean isEmpty() {
		return stack.isEmpty();
			
	}
	
    @SuppressWarnings("unchecked")
	@Override
	public Stack<IStmt> getIterator() {
		return (Stack<IStmt>) this.stack.clone();
	}
    
    public String toString() {
		String toReturn = "";
		toReturn += "ExecStack: \r\n";
		boolean empty = true;
		for(int i = stack.size() - 1 ; i >= 0 ; i--) {
			empty = false;			
			toReturn += '\t' + stack.get(i).toString() + "\r\n";
			
		}
		
		if(empty)
			toReturn += "Empty";
		return toReturn;
	}
}
