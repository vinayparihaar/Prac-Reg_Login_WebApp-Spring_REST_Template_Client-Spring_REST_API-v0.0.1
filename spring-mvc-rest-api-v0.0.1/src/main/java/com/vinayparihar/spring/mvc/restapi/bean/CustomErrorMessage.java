/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.bean;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 3:39:03 PM
 */

@JsonPropertyOrder({ "timestamp", "errorStatus", "errorMessage" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomErrorMessage {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonProperty("timestamp")
	private LocalDateTime timestamp;

	@JsonProperty("errorStatus")
	private int errorStatus;

	@JsonProperty("errorMessage")
	private String errorMessage;

	public CustomErrorMessage() {

	}

	public CustomErrorMessage(LocalDateTime timestamp, int errorStatus, String errorMessage) {
		super();
		this.timestamp = timestamp;
		this.errorStatus = errorStatus;
		this.errorMessage = errorMessage;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(int errorStatus) {
		this.errorStatus = errorStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "CustomErrorMessage [timestamp=" + timestamp + ", errorStatus=" + errorStatus + ", errorMessage="
				+ errorMessage + "]";
	}
	
	

}
