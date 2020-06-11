/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 11:01:36 PM
 */

@JsonPropertyOrder({ "email", "password" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogIn {

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
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
