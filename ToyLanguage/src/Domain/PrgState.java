package Domain;

import java.io.IOException;
import java.util.ArrayList;

import Exceptions.*;
import Stmt.IStmt;

public class PrgState implements IPrgState{
	public MyIStack myStack;
	public IOutput output;
	public ISymbTbl symtbl;
	public IFileTbl fileTbl;
	public IHeap heap;
	
 	public PrgState() {
 		this.myStack = new MyStack();
		this.output = new Output();
		this.symtbl = new SymbTbl();
		this.fileTbl = new FileTbl();
		this.heap = new Heap();
	}
 	public PrgState(MyIStack myStack, IOutput output, ISymbTbl symtbl, IFileTbl fileTbl, IHeap heap) {
 		this.myStack = myStack;
		this.output = output;
		this.symtbl = symtbl;
		this.fileTbl = fileTbl;
		this.heap = heap;
	}


	public PrgState(PrgState pr) {
		this.myStack = new MyStack((MyStack)pr.myStack);
		this.output = new Output((Output)pr.output);
		this.symtbl = new SymbTbl((SymbTbl)pr.symtbl);
		this.fileTbl = new FileTbl((FileTbl)pr.fileTbl);
		this.heap = new Heap((Heap) pr.heap);
	}


	public void addStatement(IStmt s) {
		myStack.push(s);
	}
	
	public void executeNextStep() throws InvalidSignException, InvalidStateException, DuplicateSymbolException,
	InvalidFileException, IOException, DuplicateFileException, InvalidSymbolException, InvalidAddressException, NullAdressException, OperandException, ZeroDevisionException {
		if (!myStack.isEmpty()) {
			IStmt s = myStack.pop();
			s.execute(this);
		}
		else {
			throw new InvalidStateException("End of stack reached",0);
		}
		
	}
	
	public String toString() {
		String toReturn = "_________________________________________________________________\n\n";
		toReturn += myStack.toString();
		toReturn += "\r\n";
		toReturn += symtbl.toString();
		toReturn += "\r\n";
		toReturn += fileTbl.toString();
		toReturn += "\r\n";
		toReturn += heap.toString();
		toReturn += "\r\n";
		toReturn += output.toString();
		toReturn += "\r\n";
		return toReturn;
		
	}
	
	public ArrayList<Integer> getOutput() {
		return (ArrayList<Integer>) this.output.getIterator();
	}
	
	@Override
	public boolean isDone() {
		return this.myStack.isEmpty();
	}
	
	@Override
	public IHeap getHeap() {
		return heap;
	}
 	@Override
	public ISymbTbl getSymTable() {
		return symtbl;
	}
	@Override
	public IFileTbl getFileTbl() {
		return fileTbl;
	}

}
