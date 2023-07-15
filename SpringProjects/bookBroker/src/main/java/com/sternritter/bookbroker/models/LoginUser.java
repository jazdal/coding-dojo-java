package com.sternritter.bookbroker.models;

import jakarta.validation.constraints.Email;

/* This model class is designed to be a temporary instance, 
 * and not a database entity or table. */
public class LoginUser {
	// MODEL STRUCTURE
	@Email
	private String email;
	
	private String password;
	
	// CONSTRUCTORS
	// Constructor 1: Blank constructor
	public LoginUser() {
	}

	// Constructor 2: With fields
	public LoginUser(
			String email,
			String password
			) {
		this.email = email;
		this.password = password;
	}

	// GETTERS AND SETTERS
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
