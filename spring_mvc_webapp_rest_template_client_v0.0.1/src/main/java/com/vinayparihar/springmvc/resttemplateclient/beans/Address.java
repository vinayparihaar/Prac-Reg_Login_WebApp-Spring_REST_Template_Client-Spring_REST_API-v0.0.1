/**
 * 
 */
package com.vinayparihar.springmvc.resttemplateclient.beans;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author VinayParihar
 * @alphaX @date Jun 5, 2020 @time 1:52:05 PM
 */

@JsonPropertyOrder({ "addressid", "lineOne", "lineTwo", "city", "state", "zipcode", "country" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {

	@JsonProperty("addressid")
	private int addressid;

	@NotEmpty(message = "*Line one of address is required.")
	@JsonProperty("lineOne")
	private String lineOne;

	@NotEmpty(message = "*Line two of address is required.")
	@JsonProperty("lineTwo")
	private String lineTwo;

	@NotEmpty(message = "*City is required.")
	@JsonProperty("city")
	private String city;

	@NotEmpty(message = "*State is required.")
	@JsonProperty("state")
	private String state;

	@NotEmpty(message = "*ZipCode is required.")
	@Size(min = 5, message = "*Zipcode should be 5 digits.")
	@JsonProperty("zipcode")
	private String zipcode;

	@NotEmpty(message = "*Country is required.")
	@JsonProperty("country")
	private String country;

	public Address() {

	}

	public Address(int addressid, String lineOne, String lineTwo, String city, String state, String zipcode,
			String country) {
		super();
		this.addressid = addressid;
		this.lineOne = lineOne;
		this.lineTwo = lineTwo;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getLineOne() {
		return lineOne;
	}

	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}

	public String getLineTwo() {
		return lineTwo;
	}

	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
