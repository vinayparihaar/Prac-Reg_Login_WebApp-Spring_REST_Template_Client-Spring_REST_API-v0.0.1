/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 12:49:11 PM
 */

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_FIRST_NAME")
	private String userFirstName;

	@Column(name = "USER_LAST_NAME")
	private String userLastName;

	@Column(name = "USER_EMAIL")
	private String userEmail;

	@Column(name = "USER_PHONE")
	private String userPhone;

	@Column(name = "USER_PASSWORD")
	private String userPassword;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private AddressDetails userAddressDetails;

	public UserDetails() {

	}

	public UserDetails(int userId, String userFirstName, String userLastName, String userEmail, String userPhone,
			String userPassword, AddressDetails userAddressDetails) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userPassword = userPassword;
		this.userAddressDetails = userAddressDetails;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public AddressDetails getUserAddressDetails() {
		return userAddressDetails;
	}

	public void setUserAddressDetails(AddressDetails userAddressDetails) {
		this.userAddressDetails = userAddressDetails;
	}

}
