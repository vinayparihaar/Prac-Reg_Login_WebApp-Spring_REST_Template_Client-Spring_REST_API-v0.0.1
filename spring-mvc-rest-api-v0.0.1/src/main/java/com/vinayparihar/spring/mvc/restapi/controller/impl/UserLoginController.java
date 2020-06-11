/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.controller.impl;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinayparihar.spring.mvc.restapi.bean.LogIn;
import com.vinayparihar.spring.mvc.restapi.bean.User;
import com.vinayparihar.spring.mvc.restapi.error.InvalidInputException;
import com.vinayparihar.spring.mvc.restapi.error.UserNotFoundException;
import com.vinayparihar.spring.mvc.restapi.service.IUserLogInService;
import com.vinayparihar.spring.mvc.restapi.utils.Utils;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 2:02:17 PM
 */

@RestController
public class UserLoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
	@Autowired
	private IUserLogInService iUserLogInService;
	private List<User> listOfUsers;

	@RequestMapping(value = "/login/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {

		LOGGER.debug("Processing getUserByEmail.");
		if (Utils.isEmpty(email)) {

			LOGGER.error("Email field is null or empty.");
			throw new InvalidInputException("Email field is empty." + HttpStatus.UNPROCESSABLE_ENTITY);
		} else {
			
			return new ResponseEntity<User>(iUserLogInService.getUserbyEmail(email), HttpStatus.FOUND);
		}
	}

	
	@RequestMapping(value = "/login/getallusers")
	public ResponseEntity<List<User>> getAllUsers(@QueryParam("offset") int offset, @QueryParam("limit") int limit) {

		LOGGER.debug("Processing getAllUsers.");
		listOfUsers = iUserLogInService.getAllUsers(offset, limit);
		if (listOfUsers == null) {
			
			LOGGER.error("No user record's found found in database.");
			throw new UserNotFoundException("No user record's found found in database." + HttpStatus.NOT_FOUND );
		}
		
		return new ResponseEntity<List<User>>(iUserLogInService.getAllUsers(offset, limit), HttpStatus.FOUND);
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> authenticateUser(@RequestBody LogIn logIn) {

		LOGGER.debug("Processing authenticateUser.");
		if (logIn != null) {
			if (!Utils.isEmpty(logIn.getEmail()) && !Utils.isEmpty(logIn.getPassword())) {

				boolean result = iUserLogInService.authenticateUser(logIn);
				if (result) {

					return new ResponseEntity<User>(iUserLogInService.getUserbyEmail(logIn.getEmail()),HttpStatus.FOUND);
				}
			}
		}
		LOGGER.error("Email or Password is Invalid. ");
		throw new InvalidInputException("Invalid Email or Password. " + HttpStatus.UNPROCESSABLE_ENTITY);
	}
}
