package com.sternritter.authentication.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/* This model class is designed to be a temporary instance, 
 * and not a database entity / table */
public class LoginUser {
	// MODEL STRUCTURE
	@NotEmpty(message = "Email is required!")
	@Email(message = "Please enter a valid email!")
	private String email;
	
	@NotEmpty(message = "Password is required!")
	@Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters.")
	private String password;
	
	// CONSTRUCTORS
	// Constructor 1: Empty constructor
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
