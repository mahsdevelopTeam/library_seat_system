package library.seat.manage.exception;

/**
 * 
 * @author mahs
 * @version 1.0
 * @created 2-1-2013 13:20:00
 */
public class InvalidArgumentException extends RuntimeException {
	public InvalidArgumentException() {
		super();
	}

	public InvalidArgumentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidArgumentException(String arg0) {
		super(arg0);
	}

	public InvalidArgumentException(Throwable arg0) {
		super(arg0);
	}
}
