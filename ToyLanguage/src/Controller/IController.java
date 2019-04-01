package Controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import Exceptions.*;
import Domain.IPrgState;

public interface IController {
	public void executeAllSteps() ;
	
	public void nextStep() throws  InvalidStateException, InvalidSignException,
		DuplicateSymbolException, InvalidFileException, DuplicateFileException, IOException, OperandException, ZeroDevisionException, InvalidSymbolException, InvalidAddressException, NullAdressException;
	
	public IPrgState getNextState(IPrgState s) throws InvalidStateException,
	InvalidSignException, DuplicateSymbolException, InvalidFileException, IOException, DuplicateFileException, OperandException, ZeroDevisionException, InvalidSymbolException, InvalidAddressException, NullAdressException;
	
	public HashMap<Integer, Integer> conservativeGarbageCollector(Collection<Integer> symTableValues,HashMap<Integer, Integer> heap);
}