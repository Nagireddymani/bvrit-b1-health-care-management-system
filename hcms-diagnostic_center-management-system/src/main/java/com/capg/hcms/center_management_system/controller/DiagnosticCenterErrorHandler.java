package com.capg.hcms.center_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.center_management_system.exception.CenterNameAlreadyExistException;
import com.capg.hcms.center_management_system.exception.CenterNotFoundException;

@RestController
@ControllerAdvice
public class DiagnosticCenterErrorHandler {

	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Center Name Already Exist")
	@ExceptionHandler(CenterNameAlreadyExistException.class)
	public void handleCenterNameAlreadyExistException()
	{
	       //To Handle CenterName Already Exist Exception	
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Center Not Found ")
	@ExceptionHandler(CenterNotFoundException.class)
	public void handleCenterNotFoundException()
	{
	       //To Handle Center Not Found Exception	
	}
}
