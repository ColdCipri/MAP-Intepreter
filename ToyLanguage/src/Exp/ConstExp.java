package Exp;

import Domain.IHeap;
import Domain.ISymbTbl;

public class ConstExp implements IExp{
	int s;
	
	public ConstExp(int val) {
		this.s = val;
	}

	@Override
	public int resolve(ISymbTbl st, IHeap heap) {
		return s;
	}

	@Override
	public boolean isTrue(ISymbTbl st,IHeap heap) {
		if (this.resolve(st, heap) != 0)
			return true;
		else
			return false;
	}
	
	public String toString() {
    	return  Integer.toString(s) ;
    }
}
