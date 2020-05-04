package com.capg.hcms.test_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.test_management_system.exception.ListisEmptyException;
import com.capg.hcms.test_management_system.exception.TestAlreadyExistException;
import com.capg.hcms.test_management_system.exception.TestNotFoundException;

@ControllerAdvice
@RestController
public class DiagnosticTestErrorController {
	
	@ExceptionHandler(TestNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Test Not Found" , code = HttpStatus.NOT_FOUND)
	public void handleTestNotFoundException() {
		
	}
	
	@ExceptionHandler(TestAlreadyExistException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Test with this name already exists" , code = HttpStatus.NOT_FOUND)
	public void handleTestAlreadyExistException() {
		
	}
	
	@ExceptionHandler(ListisEmptyException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "List is Empty" , code = HttpStatus.NOT_FOUND)
	public void handleListisEmptyException() {
		
	}
}
