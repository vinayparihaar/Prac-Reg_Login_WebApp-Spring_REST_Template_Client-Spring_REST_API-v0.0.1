/**
 * 
 */
package com.vinayparihar.springmvc.resttemplateclient.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author VinayParihar
 * @alphaX @date Jun 5, 2020 @time 1:52:05 PM
 */

@JsonPropertyOrder({ "email", "password" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogIn {

	@JsonProperty("email")
	@NotEmpty(message = "*Email is required.")
	@Email
	private String email;

	@JsonProperty("password")
	@NotEmpty(message = "*Password is required.")
	private String password;

	public LogIn() {

	}

	public LogIn(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

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
