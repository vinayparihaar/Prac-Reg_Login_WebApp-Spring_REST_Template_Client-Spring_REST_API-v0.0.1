/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vinayparihar.spring.mvc.restapi.bean.User;
import com.vinayparihar.spring.mvc.restapi.error.InvalidInputException;
import com.vinayparihar.spring.mvc.restapi.error.UserExistException;
import com.vinayparihar.spring.mvc.restapi.service.IUserRegistrationService;
import com.vinayparihar.spring.mvc.restapi.utils.Utils;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 1:53:33 PM
 */

@RestController
public class UserRegistrationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationController.class);
	@Autowired
	private IUserRegistrationService iUserRegistrationService;
	private HttpHeaders httpHeaders;

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> createUser(@RequestBody User user) {

		LOGGER.debug("Processing createUser.");
		if(user==null) {
			
			LOGGER.error("User details are null or empty.");
			throw new InvalidInputException("User details are empty." + HttpStatus.UNPROCESSABLE_ENTITY);
		}else {
			
			if (ifUserEmailExists(user)) { // return false;
				
				LOGGER.debug("User record exist in database with email, " + user.getEmail());
				throw new UserExistException("User record exist in database with email, " + "( " + user.getEmail() + " ), "+ HttpStatus.UNPROCESSABLE_ENTITY);	
			}
			
			httpHeaders = new HttpHeaders();
			httpHeaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest()
																   .path("/{email}")
					                                               .buildAndExpand(user.getEmail())
					                                               .toUri()
					                                               .toString());
			return new ResponseEntity<Boolean>(iUserRegistrationService.createUser(user), httpHeaders, HttpStatus.CREATED);
		}
	}

	
	public boolean ifUserEmailExists(User user) {

		LOGGER.debug("Entered ifUserEmailExists.");
		validateUser(user);
		return iUserRegistrationService.ifUserEmailExists(user);
	}

	
	private void validateUser(User user) {

		LOGGER.debug("Processing validateUser.");
		if (user != null) {

			if (Utils.isEmpty(user.getFirstName())) {
				
				LOGGER.error("First Name is null or empty. ");
				throw new InvalidInputException("*First Name is required. ");
			}
			if (Utils.isEmpty(user.getLastName())) {
				
				LOGGER.error("Last Name is null or empty. ");
				throw new InvalidInputException("*Last Name is required. ");
			}
			if (Utils.isEmpty(user.getEmail())) {
				
				LOGGER.error("Email is null or empty. ");
				throw new InvalidInputException("*Email is required. ");
			}
			if (Utils.isEmpty(user.getPhone())) {
				
				LOGGER.error("Phone number is null or empty. ");
				throw new InvalidInputException("*Phone Number is required. ");
			}
			if (Utils.isEmpty(user.getPassword())) {
				
				LOGGER.error("Password is null or empty. ");
				throw new InvalidInputException("*Password is required. ");
			}
			if (user.getAddress() != null) {
				
				if (Utils.isEmpty(user.getAddress().getLineOne())) {
					
					LOGGER.error("Line 1 of Address is null or empty. ");
					throw new InvalidInputException("*Line 1 of address is required. ");
				}
				if (user.getAddress().getLineTwo() == null || user.getAddress().getLineTwo().trim().length() <= 0) {
					
					LOGGER.error("Line 2 of Address is null or empty. ");
					throw new InvalidInputException("*Line 2 of address is required. ");
				}
				if (user.getAddress().getCity() == null || user.getAddress().getCity().trim().length() <= 0) {
					
					LOGGER.error("City is null or empty. ");
					throw new InvalidInputException("*City is required. ");
				}
				if (user.getAddress().getState() == null || user.getAddress().getState().trim().length() <= 0) {
					
					LOGGER.error("State is null or empty. ");
					throw new InvalidInputException("*State is required. ");
				}

				if (user.getAddress().getZipcode() == null || user.getAddress().getZipcode().trim().length() <= 0) {
					
					LOGGER.error("Zipcode is null or empty. ");
					throw new InvalidInputException("*Zipcode is required. ");
				}

				if (user.getAddress().getCountry() == null || user.getAddress().getCountry().trim().length() <= 0) {
					
					LOGGER.error("Country is null or empty. ");
					throw new InvalidInputException("*Country is required. ");
				}
			} else {
				
				LOGGER.error("Address fields are null or empty.");
				throw new InvalidInputException(
						"*Address fields cannot be empty.Please fill all the required fields. ");
			}
		} else {
			
			LOGGER.error("User Details are null or empty.");
			throw new InvalidInputException("*Form Cannot be empty.Please fill all the required fields. ");
		}
	}
}
