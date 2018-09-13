package com.prac.rest.webservices.restfulwebservices.exceptionhandlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prac.rest.webservices.restfulwebservices.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request){

		   HttpHeaders responseHeaders = new HttpHeaders();
		   responseHeaders.set("Exception", exception.toString());
		   return new ResponseEntity<Object>(request.getDescription(false), responseHeaders, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception exception, WebRequest request){

		   HttpHeaders responseHeaders = new HttpHeaders();
		   responseHeaders.set("Exception", exception.toString());
		   return new ResponseEntity<Object>(request.getDescription(false), responseHeaders, HttpStatus.NOT_FOUND);
	}

}
