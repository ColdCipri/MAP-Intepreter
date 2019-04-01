package Exceptions;

public class NullSymbolException extends Exception {
	 // Parameterless Constructor
    public NullSymbolException() {}

    // Constructor that accepts a message
    public NullSymbolException(String message)
    {
       super(message);
    }
}
