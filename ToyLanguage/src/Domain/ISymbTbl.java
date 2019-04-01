package Domain;

import java.util.HashMap;
import java.util.Set;

import Exceptions.DuplicateSymbolException;
import Exceptions.InvalidSymbolException;

public interface ISymbTbl {
	int getValueOf(String s) throws InvalidSymbolException ;
	void addSymbol (String s, int val) throws DuplicateSymbolException;
	void setValue(String s , int val) throws InvalidSymbolException;
	Set<String> getKeyset();
	String toString();
	HashMap<String, Integer> getContent();
}