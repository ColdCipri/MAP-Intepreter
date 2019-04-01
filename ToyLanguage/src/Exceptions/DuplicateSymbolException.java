package Exceptions;

public class DuplicateSymbolException extends Exception {
	 // Parameterless Constructor
    public DuplicateSymbolException() {}

    // Constructor that accepts a message
    public DuplicateSymbolException(String message)
    {
       super(message);
    }
}
