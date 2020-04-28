package com.capg.hcms.register_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.register_management_system.exception.ContactNumberAlreadyExistException;
import com.capg.hcms.register_management_system.exception.EmailAlreadyExistException;
import com.capg.hcms.register_management_system.exception.UserNameAlreadyExistException;
import com.capg.hcms.register_management_system.exception.UserNotFoundException;

@RestController
@ControllerAdvice
public class RegisterErrorHandler {

	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "UserName Already Exist")
	@ExceptionHandler(UserNameAlreadyExistException.class)
	public void handleUserNameAlreadyExistException()
	{
		//TO handle User Name Already Exception
	}
	
	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "ContactNumber Already Exist")
	@ExceptionHandler(ContactNumberAlreadyExistException.class)
	public void handleContactNumberAlreadyExistException()
	{
		//TO handle ContactNumber Already Exception
	}
	
	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Email Already Exist")
	@ExceptionHandler(EmailAlreadyExistException.class)
	public void handleEmailAlreadyExistException()
	{
		//TO handle Email Already Exception
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "User Not Found")
	@ExceptionHandler(UserNotFoundException.class)
	public void handleUserNotFoundException()
	{
		//TO handle UserNotFound Exception
	}
}
