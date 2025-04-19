package com.application.ecommerce.model;

public class RegisterResponse {
	private Object user;
	private String message;
	public RegisterResponse(Admin admin, String stringuser) {
		this.user=admin;
		this.message=stringuser;
	}
	
	/**
	 * @return the user
	 */
	public Object getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(Object user) {
		this.user = user;
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
