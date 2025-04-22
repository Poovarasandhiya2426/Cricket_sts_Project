package com.application.exceptionHandling;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.application.entity.ApplicationEntity;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(NameNotFoundException.class)
	
	public ResponseEntity<Object> NameNot(NameNotFoundException NE) {
	    return new ResponseEntity<Object>("Error" , HttpStatus.NOT_FOUND);
	} 
	
	@ExceptionHandler(IdNotFoundException.class)
	
	public ResponseEntity<Object> IdNot(IdNotFoundException IF) {
	    return new ResponseEntity<Object>(IF.getMessage(), HttpStatus.NOT_FOUND);
	} 
	
	@ExceptionHandler(ratingNotFoundException.class)
	
	public ResponseEntity<Object> ratingNot(ratingNotFoundException RE) {
	    return new ResponseEntity<Object>(RE.getMessage(), HttpStatus.NOT_FOUND);
	} 
	
	
	
	@ExceptionHandler(NameNotFoundExceptionJquery.class)
	
	public ResponseEntity<Object> JNamenot(NameNotFoundExceptionJquery JNE) {
	    return new ResponseEntity<Object>(JNE.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> nosuch(NoSuchElementException ns) {
		return new ResponseEntity<Object>(ns.getMessage(), HttpStatus.NOT_FOUND);
	}
	

}
