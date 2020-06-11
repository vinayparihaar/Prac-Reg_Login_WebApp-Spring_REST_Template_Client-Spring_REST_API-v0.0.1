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

import com.vinayparihar.springmvc.resttemplateclient.beans.User;
import com.vinayparihar.springmvc.resttemplateclient.service.IRegistrationService;

/**
 * @author VinayParihar
 * @alphaX @date Jun 7, 2020 @time 11:25:04 AM
 */

@Service
public class RegistrationService implements IRegistrationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationService.class);
	private RestTemplate restTemplate;
	private HttpHeaders httpHeaders;
	private HttpEntity<User> httpEntity;
	@Value( "${register.url}" ) 
	private String registerURL;

	@Override
	public boolean registerUser(User user) {

		LOGGER.debug("Processing registerUser.");
		String result = null;
		//final String uri = "http://localhost:8010/springmvcrestapi/register";
		restTemplate = new RestTemplate();

		httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", "application/json");

		httpEntity = new HttpEntity<User>(user, httpHeaders);
		
		try {
			result = restTemplate.postForEntity(registerURL, httpEntity, String.class).getBody();
		} catch (HttpStatusCodeException exception) {
			LOGGER.error("HttpStatusCodeException exception thrown : " + exception.toString());
			int statusCode = exception.getStatusCode().value();
			LOGGER.error("Status Code: " + statusCode);
		} catch (Exception e) {
			LOGGER.error("Exception : " + e.toString());
		}

		if (result != null) {
			boolean finalResult = Boolean.parseBoolean(result);
			if (finalResult) {
				LOGGER.debug("Registration Successfull, with email " + user.getEmail() + ".");
				return true;
			}
		}
		LOGGER.debug("Registration Unsuccessfull with email " + user.getEmail() + ".");
		return false;
	}
}
