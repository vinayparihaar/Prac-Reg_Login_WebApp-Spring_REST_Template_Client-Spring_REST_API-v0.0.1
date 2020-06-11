/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 12:50:11 PM
 */

@Entity
@Table(name = "ADDRESS_DETAILS")
public class AddressDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ADDRESS_ID")
	private int userAddrid;

	@Column(name = "USER_LINE_ONE")
	private String userAddrLineOne;

	@Column(name = "USER_LINE_TWO")
	private String userAddrLineTwo;

	@Column(name = "USER_CITY")
	private String userCity;

	@Column(name = "USER_STATE")
	private String userState;

	@Column(name = "USER_ZIPCODE")
	private String userZipcode;

	@Column(name = "USER_COUNTRY")
	private String userCountry;

	public AddressDetails() {

	}

	public AddressDetails(int userAddrid, String userAddrLineOne, String userAddrLineTwo, String userCity,
			String userState, String userZipcode, String userCountry) {
		super();
		this.userAddrid = userAddrid;
		this.userAddrLineOne = userAddrLineOne;
		this.userAddrLineTwo = userAddrLineTwo;
		this.userCity = userCity;
		this.userState = userState;
		this.userZipcode = userZipcode;
		this.userCountry = userCountry;
	}

	public int getUserAddrid() {
		return userAddrid;
	}

	public void setUserAddrid(int userAddrid) {
		this.userAddrid = userAddrid;
	}

	public String getUserAddrLineOne() {
		return userAddrLineOne;
	}

	public void setUserAddrLineOne(String userAddrLineOne) {
		this.userAddrLineOne = userAddrLineOne;
	}

	public String getUserAddrLineTwo() {
		return userAddrLineTwo;
	}

	public void setUserAddrLineTwo(String userAddrLineTwo) {
		this.userAddrLineTwo = userAddrLineTwo;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserZipcode() {
		return userZipcode;
	}

	public void setUserZipcode(String userZipcode) {
		this.userZipcode = userZipcode;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

}
