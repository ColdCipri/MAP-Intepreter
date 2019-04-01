package Domain;

import java.util.Stack;

import Stmt.IStmt;


public interface MyIStack {
	IStmt pop();
	void push(IStmt v);
	boolean isEmpty();
	Stack<IStmt> getIterator();
}

