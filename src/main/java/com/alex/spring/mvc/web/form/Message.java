package com.alex.spring.mvc.web.form;

public class Message {

	private String type;
	private String message;
	
	public Message() {
	}

	public Message(String type, String message) {
		super();
		this.type = type;
		this.message = message;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
