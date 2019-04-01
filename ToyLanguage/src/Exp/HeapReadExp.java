package Exp;

import Domain.IHeap;
import Domain.ISymbTbl;
import Exceptions.InvalidAddressException;
import Exceptions.InvalidSignException;
import Exceptions.InvalidSymbolException;
import Exceptions.NullAdressException;
import Exceptions.OperandException;
import Exceptions.ZeroDevisionException;

public class HeapReadExp implements IExp{
	public String s;
	
	public HeapReadExp(String name) {
		s = name;
	}
	
	@Override
	public int resolve(ISymbTbl st, IHeap heap) throws InvalidSymbolException, InvalidSignException, InvalidAddressException, NullAdressException, OperandException, ZeroDevisionException {
		IExp address = new ConstExp(st.getValueOf(s));
		return heap.getContent(address, st);
	}
	
	@Override
	public boolean isTrue(ISymbTbl st, IHeap heap) throws InvalidSymbolException, InvalidSignException, InvalidAddressException, NullAdressException, OperandException, ZeroDevisionException {
		if (this.resolve(st, heap) != 0 )
			return true;
		else
			return false;
	}
	
	public String toString() {
    	return "rH( " + s + ") ";
    }
 	
	
}
