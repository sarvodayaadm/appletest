package com.apple.employee.exception;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	// handling specific exception
	@ExceptionHandler(AppleEmployeeException.class)
	public ResponseEntity<?> AppleEmployeeException(AppleEmployeeException appleEmployeeException, WebRequest request){

		ErrorDetails errorDetails =
		new ErrorDetails(new Date(), appleEmployeeException.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.FOUND);
	}

	// handling global exception
	
	/*@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
		ErrorDetails errorDetails = 
				new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
*/
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> userNotFoundException(UserNotFoundException exception, WebRequest request){
		ErrorDetails errorDetails =
				new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.FOUND);
	}



	//Specific Exception implementation
	//Server side validation and exception handling
	//Open APi implementation

}