/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 3:28:39 PM
 */

public class Utils {

	private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
	
	public static boolean isEmpty(String string) {
		
		LOGGER.debug("Processing isEmpty.");
		if (string == null || string.trim().length() <= 0) {
			return true;
		} else {
			return false;
		}
	}
}
