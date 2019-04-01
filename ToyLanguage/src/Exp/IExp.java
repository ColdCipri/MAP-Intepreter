package Exp;

import Domain.IHeap;
import Domain.ISymbTbl;
import Exceptions.InvalidAddressException;
import Exceptions.InvalidSignException;
import Exceptions.InvalidSymbolException;
import Exceptions.NullAdressException;
import Exceptions.OperandException;
import Exceptions.ZeroDevisionException;

public interface IExp {
	public int resolve(ISymbTbl st, IHeap heap) throws OperandException, ZeroDevisionException, InvalidSymbolException, InvalidSignException, InvalidAddressException, NullAdressException;
	public boolean isTrue(ISymbTbl st, IHeap heap) throws OperandException, ZeroDevisionException, InvalidSymbolException, InvalidSignException, InvalidAddressException, NullAdressException;

}