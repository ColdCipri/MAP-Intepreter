package Domain;

import java.util.HashMap;
import java.util.Set;

import Exceptions.InvalidAddressException;
import Exceptions.InvalidSignException;
import Exceptions.InvalidSymbolException;
import Exceptions.NullAdressException;
import Exceptions.OperandException;
import Exceptions.ZeroDevisionException;
import Exp.IExp;

public interface IHeap {
	public int addItem(int content);
	public Set<Integer> getKeySet();
	public int getContent(IExp address, ISymbTbl st) throws InvalidSignException, InvalidAddressException, NullAdressException, InvalidSymbolException, InvalidAddressException, OperandException, ZeroDevisionException;
	public void updateValue(int address, int value) throws NullAdressException, InvalidAddressException;
	public HashMap<Integer,Integer> getContent();
	public void setContent( HashMap<Integer,Integer> c);
 }