/**
 * 
 */
package com.vinayparihar.springmvc.resttemplateclient.controller.impl;

import javax.servlet.http.HttpSession;
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

import com.vinayparihar.springmvc.resttemplateclient.beans.LogIn;
import com.vinayparihar.springmvc.resttemplateclient.beans.User;
import com.vinayparihar.springmvc.resttemplateclient.service.ILoginService;
import com.vinayparihar.springmvc.resttemplateclient.utils.Utils;

/**
 * @author VinayParihar
 * @alphaX @date Jun 5, 2020 @time 1:49:17 PM
 */

@Controller
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	private ModelAndView modelAndView;
	@Autowired
	private ILoginService iLoginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(@Valid @ModelAttribute("login") LogIn login, BindingResult bindingResult,
			HttpSession httpSession) {

		LOGGER.debug("Processing login.");
		if (login == null || Utils.isEmpty(login.getEmail()) || Utils.isEmpty(login.getPassword())) {
			LOGGER.error("Email and Password cannot be empty.");
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("Error", "*Please provide valid Email and Password.");
			return modelAndView;
		}

		if (bindingResult.hasErrors()) {
			LOGGER.error("Invalid inputs provided, login cannot be processed with email " + login.getEmail() + " .");
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("Email", "*Invalid Email.");
			modelAndView.addObject("Password", "*Invalid Password.");
			return modelAndView;

		} else {
			User user = iLoginService.loginUser(login);

			if (user == null) {
				LOGGER.error("User data is null for email " + login.getEmail() + " .");
				modelAndView = new ModelAndView("login");
				modelAndView.addObject("invalidEmailPassword", "*Invalid Email or Password.");
				return modelAndView;

			}
			LOGGER.debug("Login success,redirecting to loginsuccess page.");
			modelAndView = new ModelAndView("loginsuccess");
			httpSession.setAttribute("email", login.getEmail());
			httpSession.setAttribute("password", login.getPassword());

			modelAndView.addObject("user", user);
			/* (or) */
			/*
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
			// modelAndView.addObject("noUserInfo", "No Userdetails available for provided
			// Email or Password.")
			return modelAndView;
		}

	}

}
