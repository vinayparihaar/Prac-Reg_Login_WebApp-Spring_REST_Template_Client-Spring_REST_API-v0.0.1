/**
 * 
 */
package com.vinayparihar.springmvc.resttemplateclient.beans;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author VinayParihar
 * @alphaX @date Jun 5, 2020 @time 1:52:05 PM
 */

@JsonPropertyOrder({ "id", "firstName", "lastName", "email", "phone", "password", "address" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

	@JsonProperty("id")
	private int id;

	@NotEmpty(message = "*First Name is required.")
	@JsonProperty("firstName")
	private String firstName;

	@NotEmpty(message = "*Last Name is required.")
	@JsonProperty("lastName")
	private String lastName;

	@NotEmpty(message = "*Email is required.")
	@Email
	@JsonProperty("email")
	private String email;

	@NotEmpty(message = "*Phone number is required.")
	@Size(min = 10, message = "*Phone number should be min 10 characters.")
	@JsonProperty("phone")
	private String phone;

	@NotEmpty(message = "*Password is required.")
	@JsonProperty("password")
	private String password;

	@JsonProperty("address")
	@Valid
	private Address address;

	public User() {

	}

	public User(int id, String firstName, String lastName, String email, String phone, String password,
			Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
