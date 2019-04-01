package Domain;

import java.util.Formatter;
import java.util.HashMap;
import java.util.Set;

import Exceptions.InvalidAddressException;
import Exceptions.InvalidSignException;
import Exceptions.InvalidSymbolException;
import Exceptions.NullAdressException;
import Exceptions.OperandException;
import Exceptions.ZeroDevisionException;
import Exp.IExp;

public class Heap implements IHeap{
	public HashMap<Integer, Integer> heap;
	private int nextAddress;
	
	public Heap() {
		this.nextAddress = 1;
		heap = new HashMap<>();
	}
	
	public Heap(Heap h) {
		heap = new HashMap<>(h.heap);
		nextAddress = h.nextAddress;
	}
	
	@Override
	public int addItem(int content) {
		heap.put(nextAddress, content);
		nextAddress++;
		return nextAddress - 1;
	}

	
	@Override
	public Set<Integer> getKeySet() {
 		return heap.keySet();
	}
	
	@Override
	public int getContent(IExp address, ISymbTbl st) throws InvalidSignException, InvalidAddressException, NullAdressException, InvalidSymbolException, OperandException, ZeroDevisionException {
		int actualAddress = address.resolve(st,this);
		if (actualAddress == 0) {
			throw new NullAdressException("Adress is 0",1);
		}
		if (heap.get(actualAddress) == null)
			throw new InvalidAddressException("Invalid address " + actualAddress, 0);
 		return heap.get(actualAddress);
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		Formatter form = new Formatter();
		boolean empty = true;
		toReturn += "\r\nHeap: \r\n";
		for(Integer k : heap.keySet()) {
			try {			
				form.format("	%-5d = %-5d\r\n", k, heap.get(k) );
				empty = false;
			} catch (Exception e) {
				
			}
		}
		if(empty)
			toReturn += "	Empty\r\n";
		toReturn += form.toString();
		form.close();
		return toReturn;
		
	}
	
	@Override
	public void updateValue(int address, int value) throws NullAdressException, InvalidAddressException {
		if (address == 0) {
			throw new NullAdressException("Adress is 0",1);
		}
		if (heap.get(address) == null) {
			throw new InvalidAddressException("Invalid address " + address, 0);			
		}
		heap.put(address, value);
		
	}
	@Override
	public HashMap<Integer, Integer> getContent() {
		return heap;
	}
	@Override
	public void setContent(HashMap<Integer, Integer> c) {
		this.heap = c;
		
	}
}
