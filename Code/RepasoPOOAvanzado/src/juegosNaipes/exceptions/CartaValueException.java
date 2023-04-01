package juegosNaipes.exceptions;

public class CartaValueException extends Exception {
	private static final String MSG = "Numero de carta no valido";
	
	public CartaValueException() {
		super(MSG);
	}

	public CartaValueException(String message) {
		super(message);
		
	}

	public CartaValueException(Throwable cause) {
		super(cause);
		
	}

	public CartaValueException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public CartaValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
