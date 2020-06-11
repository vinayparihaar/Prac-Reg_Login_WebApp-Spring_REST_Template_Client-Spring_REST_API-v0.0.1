/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinayparihar.spring.mvc.restapi.bean.Address;
import com.vinayparihar.spring.mvc.restapi.bean.LogIn;
import com.vinayparihar.spring.mvc.restapi.bean.User;
import com.vinayparihar.spring.mvc.restapi.dao.IUserLogInDAO;
import com.vinayparihar.spring.mvc.restapi.model.UserDetails;
import com.vinayparihar.spring.mvc.restapi.service.IUserLogInService;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 11:35:36 PM
 */

@Service
public class UserLogInService implements IUserLogInService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserLogInService.class);
	@Autowired
	private IUserLogInDAO iUserLogInDAO;
	private UserDetails userDetails;
	private List<UserDetails> listOfAllUsersDetails;
	private User user;
	private List<User> userList;
	private Address address;

	@Override
	public User getUserbyEmail(String email) {
		
		LOGGER.debug("Processing getUserbyEmail.");
		userDetails = iUserLogInDAO.getUserbyEmail(email);
		if (userDetails != null) {
			
			LOGGER.debug("User record found in database with email, "+ email);
			user = new User();
			user.setId(userDetails.getUserId());
			user.setFirstName(userDetails.getUserFirstName());
			user.setLastName(userDetails.getUserLastName());
			user.setEmail(userDetails.getUserEmail());
			user.setPassword(userDetails.getUserPassword());
			user.setPhone(userDetails.getUserPhone());

			if (userDetails.getUserAddressDetails() != null) {
				
				address = new Address();
				address.setLineOne(userDetails.getUserAddressDetails().getUserAddrLineOne());
				address.setLineTwo(userDetails.getUserAddressDetails().getUserAddrLineTwo());
				address.setCity(userDetails.getUserAddressDetails().getUserCity());
				address.setState(userDetails.getUserAddressDetails().getUserState());
				address.setZipcode(userDetails.getUserAddressDetails().getUserZipcode());
				address.setCountry(userDetails.getUserAddressDetails().getUserCountry());
			}
			user.setAddress(address);
			return user;

		} else {
			
			LOGGER.error("No user record found in database with email, "+ email);
			return null;
		}
	}

	
	@Override
	public List<User> getAllUsers(int offset, int limit) {
		
		LOGGER.debug("Processing getAllUsers.");
		listOfAllUsersDetails = iUserLogInDAO.getAllUsers(offset, limit);
		if (listOfAllUsersDetails != null && !listOfAllUsersDetails.isEmpty()) {
			
			userList = new ArrayList<User>();

			for (UserDetails userDetails : listOfAllUsersDetails) {
				
				user = new User();
				user.setId(userDetails.getUserId());
				user.setFirstName(userDetails.getUserFirstName());
				user.setLastName(userDetails.getUserLastName());
				user.setEmail(userDetails.getUserEmail());
				user.setPassword(userDetails.getUserPassword());
				user.setPhone(userDetails.getUserPhone());

				if (userDetails.getUserAddressDetails() != null) {

					address = new Address();
					address.setLineOne(userDetails.getUserAddressDetails().getUserAddrLineOne());
					address.setLineTwo(userDetails.getUserAddressDetails().getUserAddrLineTwo());
					address.setCity(userDetails.getUserAddressDetails().getUserCity());
					address.setState(userDetails.getUserAddressDetails().getUserState());
					address.setZipcode(userDetails.getUserAddressDetails().getUserZipcode());
					address.setCountry(userDetails.getUserAddressDetails().getUserCountry());
				}
				user.setAddress(address);
				userList.add(user);
			}

		} else {
			LOGGER.error("UserDetails are null in getAllUsers. ");
			return null;
		}
		return userList;
	}

	
	@Override
	public boolean authenticateUser(LogIn logIn) {
		
		LOGGER.debug("Processing authenticateUser.");
		userDetails = iUserLogInDAO.getUserbyEmail(logIn.getEmail());
		if (userDetails != null && userDetails.getUserEmail().equals(logIn.getEmail())
				&& userDetails.getUserPassword().equals(logIn.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
}
