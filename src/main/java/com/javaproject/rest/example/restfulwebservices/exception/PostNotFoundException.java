package com.javaproject.rest.example.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class PostNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2L;

	public PostNotFoundException(String arg0) {
		super(arg0);
	}
}