package Exceptions;

public class ZeroDevisionException extends Exception {
	 // Parameterless Constructor
    public ZeroDevisionException() {}

    // Constructor that accepts a message
    public ZeroDevisionException(String message)
    {
       super(message);
    }
}
