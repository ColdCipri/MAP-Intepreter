package Exp;

import Domain.IHeap;
import Domain.ISymbTbl;
import Exceptions.InvalidAddressException;
import Exceptions.InvalidSignException;
import Exceptions.InvalidSymbolException;
import Exceptions.NullAdressException;
import Exceptions.OperandException;
import Exceptions.ZeroDevisionException;

public class ArithExp implements IExp{
	public char op;
	public IExp e1;
	public IExp e2;
	
	public ArithExp(char op, IExp e1, IExp e2) {
		this.op=op;
		this.e1=e1;
		this.e2=e2;
	}
	
	
	@Override
	public int resolve(ISymbTbl st,IHeap heap) throws OperandException, ZeroDevisionException, InvalidSymbolException, InvalidSignException, InvalidAddressException, NullAdressException {
		int s = 0;
		try {
			int operator1 = e1.resolve(st, heap);	
			int operator2 = e2.resolve(st, heap);
			
				switch(op) {
					case '+':
						s = operator1+operator2;
						break;
					case '-':
						s = operator1-operator2;
						break;
					case '*':
						s = operator1*operator2;
						break;
					case '/':
						if (operator2 == 0 )
							throw new ZeroDevisionException("Found division by 0");
						s = operator1/operator2;
						break;
				default:
					if ( op != '+' & op != '-' & op != '*' & op != '/')
						throw new OperandException("Operand error, found "+ op  );
					break;
				}
			}
		catch (NullPointerException e) {
			//throw new NullPointerException("Found null operator" + e1 +e2);
		}
		return s;
	}

	@Override
	public boolean isTrue(ISymbTbl st, IHeap heap) throws InvalidSignException, InvalidSymbolException, InvalidAddressException, NullAdressException, OperandException, ZeroDevisionException {
		if (this.resolve(st, heap) != 0)
			return true;
		else 
			return false;
	}

	public String toString() {
		return e1 + " " + op + " " + e2;
	}
}
