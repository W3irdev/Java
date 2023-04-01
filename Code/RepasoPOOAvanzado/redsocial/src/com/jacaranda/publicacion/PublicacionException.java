package com.jacaranda.publicacion;

public class PublicacionException extends Exception {

	public PublicacionException() {
	}

	public PublicacionException(String message) {
		super(message);
	}

	public PublicacionException(Throwable cause) {
		super(cause);
	}

	public PublicacionException(String message, Throwable cause) {
		super(message, cause);
	}

	public PublicacionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
