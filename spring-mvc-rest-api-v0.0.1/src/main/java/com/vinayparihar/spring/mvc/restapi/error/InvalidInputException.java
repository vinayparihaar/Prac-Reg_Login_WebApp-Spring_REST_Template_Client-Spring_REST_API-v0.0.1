/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 3:45:36 PM
 */

@ResponseStatus( value = HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8304867865682352036L;

	private static final Logger LOGGER = LoggerFactory.getLogger(InvalidInputException.class);

	public InvalidInputException(String string) {
		
		super(string);
		LOGGER.error("Throwing Error form InvalidInputException : " + string);
	}
}
