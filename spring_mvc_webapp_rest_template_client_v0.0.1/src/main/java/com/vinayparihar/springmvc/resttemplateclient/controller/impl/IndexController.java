/**
 * 
 */
package com.vinayparihar.springmvc.resttemplateclient.controller.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vinayparihar.springmvc.resttemplateclient.beans.LogIn;
import com.vinayparihar.springmvc.resttemplateclient.beans.User;

/**
 * @author VinayParihar
 * @alphaX @date Jun 6, 2020 @time 11:45:28 AM
 */

@Controller
public class IndexController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		LOGGER.debug("Processing home method GET request. ");
		
		LOGGER.debug("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		
		return "index";
	}

	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		
		LOGGER.debug("Processing index method GET request. ");
		
		LOGGER.debug("Index Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

		return "index";
	}

	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		
		LOGGER.debug("Processing register method GET request. ");
		
		LOGGER.debug("Register Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("user", new User()); 

		return "register";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {

		LOGGER.debug("Processing login method GET request. ");
		
		LOGGER.debug("Login Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("login", new LogIn()); 

		return "login";
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, HttpSession session) {
		
		LOGGER.debug("Processing logout method GET request. ");
		
		LOGGER.debug("Logout Page Requested, locale = " + locale);
		LOGGER.debug("Destroying loggedin session.");
		session.removeAttribute("email");
		session.removeAttribute("password");
		LOGGER.debug("Destroyed loggedin session.");
		model.addAttribute("login", new LogIn()); 
		
		return "login";
	}

	
	/*
	 * @RequestMapping(value = "/registrationsuccess", method = RequestMethod.GET)
	 * public String registrationsuccess(Locale locale, Model model) {
	 * 
	 * LOGGER.debug("Processing registrationsuccess method GET request. ");
	 * 
	 * LOGGER.debug("RegistrationSuccess Page Requested, locale = " + locale); Date
	 * date=new Date(); DateFormat dateFormat =
	 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * String formattedDate = dateFormat.format(date);
	 * model.addAttribute("serverTime", formattedDate);
	 * 
	 * return "registrationsuccess"; }
	 */
	 

	
	
	/*
	 * @RequestMapping(value = "/loginsuccess", method = RequestMethod.GET) public
	 * String loginsuccess(Locale locale, Model model) {
	 * 
	 * LOGGER.debug("Processing loginsuccess method GET request. ");
	 * 
	 * LOGGER.debug("LoginSuccess Page Requested, locale = " + locale); Date date =
	 * new Date(); DateFormat dateFormat
	 * =DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * String formattedDate = dateFormat.format(date);
	 * model.addAttribute("serverTime", formattedDate);
	 * 
	 * return "loginsuccess"; }
	 */
	 

}
