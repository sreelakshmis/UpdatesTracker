package com.javaproject.rest.example.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionDetails exceptionDetails = new ExceptionDetails(ex.getMessage(), request.getDescription(false),
				new Date());

		return new ResponseEntity<Object>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request)
			throws Exception {
		ExceptionDetails exceptionDetails = new ExceptionDetails(ex.getMessage(), request.getDescription(false),
				new Date());

		return new ResponseEntity<Object>(exceptionDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PostNotFoundException.class)
	public final ResponseEntity<Object> handlePostNotFoundException(PostNotFoundException ex, WebRequest request)
			throws Exception {
		ExceptionDetails exceptionDetails = new ExceptionDetails(ex.getMessage(), request.getDescription(false),
				new Date());

		return new ResponseEntity<Object>(exceptionDetails, HttpStatus.NOT_FOUND);
	}

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionDetails exceptionDetails = new ExceptionDetails("input validation failed",
				ex.getBindingResult().toString(), new Date());

		return new ResponseEntity<Object>(exceptionDetails, HttpStatus.BAD_REQUEST);
	}

}