/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinayparihar.spring.mvc.restapi.bean.User;
import com.vinayparihar.spring.mvc.restapi.dao.IUserRegistrationDAO;
import com.vinayparihar.spring.mvc.restapi.model.AddressDetails;
import com.vinayparihar.spring.mvc.restapi.model.UserDetails;
import com.vinayparihar.spring.mvc.restapi.service.IUserRegistrationService;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 7:29:20 PM
 */

@Service
public class UserRegistrationService implements IUserRegistrationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationService.class);
	@Autowired
	private IUserRegistrationDAO iUserRegistrationDAO;
	private UserDetails userDetails;
	private AddressDetails addressDetails;

	@Override
	public boolean createUser(User user) {

		LOGGER.debug("Processing createUser.");
		
		userDetails = new UserDetails();
		userDetails.setUserFirstName(user.getFirstName());
		userDetails.setUserLastName(user.getLastName());
		userDetails.setUserEmail(user.getEmail());
		userDetails.setUserPhone(user.getPhone());
		userDetails.setUserPassword(user.getPassword());

		addressDetails = new AddressDetails();
		addressDetails.setUserAddrLineOne(user.getAddress().getLineOne());
		addressDetails.setUserAddrLineTwo(user.getAddress().getLineTwo());
		addressDetails.setUserCity(user.getAddress().getCity());
		addressDetails.setUserState(user.getAddress().getState());
		addressDetails.setUserZipcode(user.getAddress().getZipcode());
		addressDetails.setUserCountry(user.getAddress().getCountry());

		userDetails.setUserAddressDetails(addressDetails);

		return iUserRegistrationDAO.createUser(userDetails);
	}

	
	@Override
	public boolean ifUserEmailExists(User user) {
		
		LOGGER.debug("Processing ifUserEmailExists.");
		userDetails = new UserDetails();
		userDetails.setUserEmail(user.getEmail());
		return iUserRegistrationDAO.ifUserEmailExists(userDetails);
	}
}
