/**
 * 
 */
package com.vinayparihar.springmvc.resttemplateclient.controller.impl;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vinayparihar.springmvc.resttemplateclient.beans.User;
import com.vinayparihar.springmvc.resttemplateclient.service.IRegistrationService;

/**
 * @author VinayParihar
 * @alphaX @date Jun 7, 2020 @time 10:31:20 AM
 */

@Controller
public class RegistrationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);
	private ModelAndView modelAndView;
	@Autowired
	private IRegistrationService iRegistrationService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

		LOGGER.debug("Processing registerUser.");

		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Invalid inputs provided, registartion cannot be processed with email " + user.getEmail() + " .");
			modelAndView = new ModelAndView("register");
			return modelAndView;
		} else {
			boolean result = iRegistrationService.registerUser(user);
			if (result) {
				LOGGER.debug("Registartion Successfull!!.Redirecting to registartionsuccess page.");
				modelAndView = new ModelAndView("registrationsuccess");
				modelAndView.addObject("user", user);
				/*
				 * modelAndView.addObject("user.id", user.getId());
				 * modelAndView.addObject("user.firstName", user.getFirstName());
				 * modelAndView.addObject("user.lastName", user.getLastName());
				 * modelAndView.addObject("user.email", user.getEmail());
				 * modelAndView.addObject("user.password", user.getPassword());
				 * modelAndView.addObject("user.phone", user.getPhone());
				 * modelAndView.addObject("user.address.lineOne",
				 * user.getAddress().getLineOne());
				 * modelAndView.addObject("user.address.lineTwo",
				 * user.getAddress().getLineTwo()); modelAndView.addObject("user.address.city",
				 * user.getAddress().getCity()); modelAndView.addObject("user.address.state",
				 * user.getAddress().getState()); modelAndView.addObject("user.address.zipcode",
				 * user.getAddress().getZipcode());
				 * modelAndView.addObject("user.address.country",
				 * user.getAddress().getCountry());
				 */
				return modelAndView;
			}
			LOGGER.debug("Registration failed,redirecting to registrationerror page.");
			modelAndView = new ModelAndView("registrationerror");
			modelAndView.addObject("user", user);
			return modelAndView;

		}

	}

}
