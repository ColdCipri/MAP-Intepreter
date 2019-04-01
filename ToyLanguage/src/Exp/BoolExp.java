package Exp;

import Domain.IHeap;
import Domain.ISymbTbl;
import Exceptions.InvalidAddressException;
import Exceptions.InvalidSignException;
import Exceptions.InvalidSymbolException;
import Exceptions.NullAdressException;
import Exceptions.OperandException;
import Exceptions.ZeroDevisionException;

public class BoolExp implements IExp{
	public String operand;
	public IExp op1;
	public IExp op2;
	
	public BoolExp(String operand, IExp op1, IExp op2) {
		this.operand = operand;
		this.op1 = op1;
		this.op2 = op2;
	}
	
	@Override
	public int resolve(ISymbTbl st, IHeap heap) throws OperandException, ZeroDevisionException, InvalidSymbolException,
			InvalidSignException, InvalidAddressException, NullAdressException {
		int operator1 = op1.resolve(st, heap);
		int operator2 = op2.resolve(st, heap);

		switch (operand) {
		case "<":
			if ( operator1 < operator2)
				return 1 ;
			else 
				return 0;			
		case "<=":
			if (operator1 <= operator2)	
				return 1 ;
			else 
				return 0;	
		case "==":
			if (operator1 == operator2)	
				return 1 ;
			else 
				return 0;
		case ">=":
			if (operator1 >= operator2)	
				return 1 ;
			else 
				return 0;
		case ">":
			if (operator1 > operator2)	
				return 1 ;
			else 
				return 0;
		case "!=":
			if (operator1 != operator2)	
				return 1 ;
			else 
				return 0;

		default:
			throw new InvalidSignException("Valid sign expected ( <, <=, ==, !=, >, >= ). Sign given: " + operand, 1);
		}
		
	}

	@Override
	public boolean isTrue(ISymbTbl st, IHeap heap) throws OperandException, ZeroDevisionException,
			InvalidSymbolException, InvalidSignException, InvalidAddressException, NullAdressException {
		return this.resolve(st, heap) != 0 ? true : false;
	}
	
	public String toString() {
		return op1 + " " + operand + " " + op2;
	}
}
