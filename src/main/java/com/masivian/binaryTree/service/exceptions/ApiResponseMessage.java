package com.masivian.binaryTree.service.exceptions;

import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class ApiResponseMessage {

	private String message;
	private HttpHeaders headers;
	
	public ApiResponseMessage(String message) {
		this.message = message;
		headers = new HttpHeaders();
    	headers.setAccept(Collections.singletonList(MediaType.ALL));
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
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
