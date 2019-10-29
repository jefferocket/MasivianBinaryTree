package com.masivian.binaryTree.service.exceptions;

import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * Custom Response Messages.
 * 
 * @author <a href="jefferocket@gmail.com">Jeferson Rincon</a>
 *
 */
public class ApiResponseMessage {

	/**
	 * The message to be print.
	 */
	private String message;
	/**
	 * The Headers.
	 */
	private HttpHeaders headers;
	
	public ApiResponseMessage(String message) {
		this.message = message;
		headers = new HttpHeaders();
    	headers.setAccept(Collections.singletonList(MediaType.ALL));
	}

	/**
	 * Get the message.
	 * @return the message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setting a message.
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Custom response message.
	 * @param status Status of the response.
	 * @return ResponseEntity.
	 */
	public ResponseEntity<String> generateResponse(HttpStatus status){
		ResponseEntity<String> result = null;
		switch (status) {
		case OK:
			result = new ResponseEntity<String>(message, headers, HttpStatus.OK);
			break;
		case NOT_FOUND:
			result = new ResponseEntity<String>(message, headers, HttpStatus.NOT_FOUND);
			break;

		default:
			break;
		}
		return result;
	}
	
}
