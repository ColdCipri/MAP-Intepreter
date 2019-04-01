package Exceptions;

public class NullAdressException extends Exception {

private static final long serialVersionUID = 5516220286507543629L;
	
	private final int code;
 	public NullAdressException(int code) {
		super();
		this.code = code;
	}
 	public NullAdressException(String message, Throwable cause, int code) {
		super(message, cause);
		this.code = code;
	}
 	public NullAdressException(String message, int code) {
		super(message);
		this.code = code;
	}
 	public NullAdressException(Throwable cause, int code) {
		super(cause);
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
