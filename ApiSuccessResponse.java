package com.scb.personalBanking.config;

public class ApiSuccessResponse {
	private String message;
	private Object body;
	private Object statusCode;
	private boolean success = true;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
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
