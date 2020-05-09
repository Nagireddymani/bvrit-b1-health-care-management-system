package com.capg.hcms.center_management_system.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.center_management_system.exception.CenterListIsEmptyException;
import com.capg.hcms.center_management_system.exception.CenterNameAlreadyExistException;
import com.capg.hcms.center_management_system.exception.CenterNotFoundException;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy
-Created/Modified Date    :     01-05-2020
-Description              :     DiagnosticCenterErrorController Class for handling DiagnosticCenter Management System Exceptions

*******************************************************************************************************************************/

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
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "CenterList is Empty ")
	@ExceptionHandler(CenterListIsEmptyException.class)
	public void handleCenterListIsEmptyException()
	{
	       //To Handle CenterList is Empty Exception	
	}
}
