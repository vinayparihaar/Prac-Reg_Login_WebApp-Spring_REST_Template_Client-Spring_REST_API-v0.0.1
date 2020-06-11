/**
 * 
 */
package com.vinayparihar.springmvc.resttemplateclient.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.vinayparihar.springmvc.resttemplateclient.beans.LogIn;
import com.vinayparihar.springmvc.resttemplateclient.beans.User;
import com.vinayparihar.springmvc.resttemplateclient.service.ILoginService;

/**
 * @author VinayParihar
 * @alphaX @date Jun 7, 2020 @time 12:37:45 PM
 */

@Service
public class LoginService implements ILoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
	private RestTemplate restTemplate;
	private HttpHeaders httpHeaders;
	private HttpEntity<LogIn> httpEntity;
	@Value("${login.url}")
	private String loginURL;

	@Override
	public User loginUser(LogIn logIn) {

		LOGGER.debug("Processing loginUser.");
		User user = null;
		// final String uri = "http://localhost:8010/springmvcrestapi/login";
		restTemplate = new RestTemplate();

		httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", "application/json");

		httpEntity = new HttpEntity<LogIn>(logIn, httpHeaders);

		try {
			user = restTemplate.postForEntity(loginURL, httpEntity, User.class).getBody();
		} catch (HttpStatusCodeException exception) {
			LOGGER.error("HttpStatusCodeException exception thrown : " + exception.toString());
			int statusCode = exception.getStatusCode().value();
			LOGGER.error("Status Code: " + statusCode);
		} catch (Exception e) {
			LOGGER.error("Exception : " + e.toString());
		}

		if (user != null) {
			LOGGER.debug("Login Successfull with email " + logIn.getEmail() + ".");
			LOGGER.debug("******************************X******************************");
			LOGGER.debug("User Id : " + user.getId());
			LOGGER.debug("User Id : " + user.getFirstName());
			LOGGER.debug("User Id : " + user.getLastName());
			LOGGER.debug("User Id : " + user.getEmail());
			LOGGER.debug("User Id : " + user.getPassword());
			LOGGER.debug("User Id : " + user.getPhone());
			LOGGER.debug("User Id : " + user.getAddress().getLineOne());
			LOGGER.debug("User Id : " + user.getAddress().getLineTwo());
			LOGGER.debug("User Id : " + user.getAddress().getCity());
			LOGGER.debug("User Id : " + user.getAddress().getState());
			LOGGER.debug("User Id : " + user.getAddress().getZipcode());
			LOGGER.debug("User Id : " + user.getAddress().getCountry());
			LOGGER.debug("******************************X******************************");
			return user;
		} else {
			LOGGER.debug("Login Unsuccessfull with email " + logIn.getEmail() + ".");
			return null;
		}

	}

}
