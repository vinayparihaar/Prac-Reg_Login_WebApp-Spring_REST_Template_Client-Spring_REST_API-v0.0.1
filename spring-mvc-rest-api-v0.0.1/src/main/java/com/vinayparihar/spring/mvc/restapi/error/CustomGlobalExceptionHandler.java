/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.error;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vinayparihar.spring.mvc.restapi.bean.CustomErrorMessage;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 4:12:40 PM
 */

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<CustomErrorMessage> customHandleInvalidInput(InvalidInputException invalidInputException,WebRequest request) {
			
		LOGGER.debug("Processing customHandleInvalidInput.");
		CustomErrorMessage customErrorMessage = new CustomErrorMessage();
		customErrorMessage.setTimestamp(LocalDateTime.now());
		customErrorMessage.setErrorStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		customErrorMessage.setErrorMessage(invalidInputException.getMessage());

		return new ResponseEntity<>(customErrorMessage, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<CustomErrorMessage> customHandleUserNotFound(UserNotFoundException userNotFoundException,WebRequest request) {
				
		LOGGER.debug("Processing customHandleUserNotFound.");
		CustomErrorMessage customErrorMessage = new CustomErrorMessage();
		customErrorMessage.setTimestamp(LocalDateTime.now());
		customErrorMessage.setErrorStatus(HttpStatus.NOT_FOUND.value());
		customErrorMessage.setErrorMessage(userNotFoundException.getMessage());

		return new ResponseEntity<>(customErrorMessage, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(UserExistException.class)
	public ResponseEntity<CustomErrorMessage> customHandleUserExist(UserExistException userExistException,WebRequest request) {
			
		LOGGER.debug("Processing customHandleUserExist.");
		CustomErrorMessage customErrorMessage = new CustomErrorMessage();
		customErrorMessage.setTimestamp(LocalDateTime.now());
		customErrorMessage.setErrorStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		customErrorMessage.setErrorMessage(userExistException.getMessage());

		return new ResponseEntity<>(customErrorMessage, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomErrorMessage> customHandleException(Exception exception, WebRequest request) {
		
		LOGGER.debug("Processing customHandleUserExist.");
		CustomErrorMessage customErrorMessage = new CustomErrorMessage();
		customErrorMessage.setTimestamp(LocalDateTime.now());
		customErrorMessage.setErrorStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		customErrorMessage.setErrorMessage(exception.getMessage());

		return new ResponseEntity<>(customErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
