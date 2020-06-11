/**
 * 
 */
package com.vinayparihar.springmvc.resttemplateclient.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vinayparihar.springmvc.resttemplateclient.service.impl.LoginService;

/**
 * @author VinayParihar
 * @alphaX @date Jun 4, 2020 @time 6:48:19 PM
 */

public class Utils {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

	public static boolean isEmpty(String string) {

		LOGGER.debug("Processing isEmpty.");
		
		if (string == null || string.trim().length() <= 0) {
			return true;
		} else {
			return false;
		}
	}
}
