package Exp;

import Domain.IHeap;
import Domain.ISymbTbl;

public class VarExp implements IExp{
	public String s;
	
	public VarExp(String s) {
		this.s = s;
	}

	@Override
	public int resolve(ISymbTbl st, IHeap heap) {
		try {
			return st.getValueOf(s);
		}
		catch (Exception e) {
			try {
				st.addSymbol(s, 0);
			}
			catch (Exception e2) {
				return 0;
			}
			return 0;
		}
	}

	@Override
	public boolean isTrue(ISymbTbl st, IHeap heap) {
		if (this.resolve(st, heap) != 0)
			return true;
		else 
			return false;
	}
	
	public String toString() {
    	return s;
    }
}
