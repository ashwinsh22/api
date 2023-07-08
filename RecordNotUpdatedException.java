package com.scb.personalBanking.exception;

public class RecordNotUpdatedException extends Exception{
	public RecordNotUpdatedException() {
		super();
	}
	public RecordNotUpdatedException(String message, Throwable cause) {
		super(message,cause);
	}
	public RecordNotUpdatedException(String message) {
		super(message);
	}
	public RecordNotUpdatedException(Throwable cause) {
		super(cause);
	}

}
