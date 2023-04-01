package com.jacaranda.memoryStorage;

public class MemoryStorageExcepction extends Exception {

	public MemoryStorageExcepction() {
		super();
	}

	public MemoryStorageExcepction(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MemoryStorageExcepction(String message, Throwable cause) {
		super(message, cause);
	}

	public MemoryStorageExcepction(String message) {
		super(message);
	}

	public MemoryStorageExcepction(Throwable cause) {
		super(cause);
	}

	

}
