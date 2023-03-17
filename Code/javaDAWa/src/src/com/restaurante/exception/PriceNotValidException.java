package src.com.restaurante.exception;

public class PriceNotValidException extends RuntimeException {
	
	public static final String MENSAJE_STD = "El precio introducido no es válido";

	public PriceNotValidException() {
		super(MENSAJE_STD);
	}

	public PriceNotValidException(String message) {
		super(message);
	}

	public PriceNotValidException(Throwable cause) {
		super(cause);
	}

	public PriceNotValidException(String message, Throwable cause) {
		super(message, cause);
	}

	public PriceNotValidException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
