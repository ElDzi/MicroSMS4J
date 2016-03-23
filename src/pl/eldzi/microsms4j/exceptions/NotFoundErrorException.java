package pl.eldzi.microsms4j.exceptions;

public class NotFoundErrorException extends Exception {

	private static final long serialVersionUID = -2079927675346198352L;

	public NotFoundErrorException() {
		super();
	}

	public NotFoundErrorException(String message) {
		super(message);
	}

	public NotFoundErrorException(Throwable cause) {
		super(cause);
	}

	public NotFoundErrorException(String message, Throwable cause) {
		super(message, cause);
	}
}
