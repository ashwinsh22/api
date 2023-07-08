package com.scb.personalBanking.exception;

public class RecordNotDeletedException extends Exception {
	public RecordNotDeletedException() {
		super();
	}
	
	public RecordNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public RecordNotDeletedException(String message) {
		super(message);

	}
	public RecordNotDeletedException(Throwable cause) {
		super(cause);
	}
}
