package com.application.ecommerce.model;

public class LoginResponse {
	public LoginResponse(Object object, String string, Object object2) {
		
		System.out.println("LoginResponse"+string);
	}
	private Object user;
	private String message;
	private String token;
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
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
