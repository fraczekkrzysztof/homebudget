package com.fraczekkrzysztof.homebudget.controller.rest.exception;

//klasa odpowiadająca za formatowanie błędu
public class RestErrorResponse {

	private int status;
	private String message;
	private long timestamp;
	
	public RestErrorResponse(){
		
	}

	public RestErrorResponse(int status, String message, long timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
