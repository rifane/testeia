package com.teste.common.to;

import java.io.Serializable;

public class EmailTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String to;
	
	private String message;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
