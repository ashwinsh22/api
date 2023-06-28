package com.scb.personalBanking.config;
public class ApiErrorResponse {

	private String message;
	private Object cause;
	private Object statusCode;
	
	private boolean success = false;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getCause() {
		return cause;
	}
	public void setCause(Object cause) {
		this.cause = cause;
	}
	public Object getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Object statusCode) {
		this.statusCode = statusCode;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
