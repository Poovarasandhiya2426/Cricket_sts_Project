package com.cricket.ExceptionHandler;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(TeamNotFoundException.class)
	
	public ResponseEntity<Object> teamNot(TeamNotFoundException te) {
		return new ResponseEntity<Object>(te.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(PlayerNotFoundException.class)
	public ResponseEntity<Object> playerNot(PlayerNotFoundException pe) {
		return new ResponseEntity<Object>(pe.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(CountryNotFoundException.class)
	public ResponseEntity<Object>countryNot(CountryNotFoundException ce) {
		return new ResponseEntity<Object>(ce.getMessage(), HttpStatus.NOT_FOUND);
		
	}
	
	 @ExceptionHandler(NoSuchElementException.class)
	    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex) {
	        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	 
	/*  @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleGenericException(Exception ex) {
	        return new ResponseEntity<>("Something went wrong: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    } */
	 
	 @ExceptionHandler(RoleNotFoundException.class)
	public ResponseEntity<Object> roleNot(RoleNotFoundException re) {
		return new ResponseEntity<Object> (re.getMessage(), HttpStatus.NOT_FOUND);
		 
	 }
	

}
