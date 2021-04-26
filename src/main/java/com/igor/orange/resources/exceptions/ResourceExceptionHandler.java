package com.igor.orange.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.igor.orange.services.exceptions.ObjectNotFoundException;


@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityViolationException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity<StandardError> constraintViolation(DuplicateKeyException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(HttpStatus.CONFLICT.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
}