package com.example.tectoro.pgmt.responsebean;

import java.io.Serializable;

/**
 * @author tectoro
 *
 */
public class ResponseBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8894393774984008181L;
	private Object data;
	private String message;
	private String errorMessage;
	private boolean status;
	
	public ResponseBean(Object data, String message, String errorMessage, boolean status) {
		this.data = data;
		this.message = message;
		this.errorMessage = errorMessage;
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}