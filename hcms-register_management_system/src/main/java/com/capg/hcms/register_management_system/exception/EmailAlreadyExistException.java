package com.capg.hcms.register_management_system.exception;

public class EmailAlreadyExistException extends RuntimeException{

	public EmailAlreadyExistException(String message)
	{
		super(message);
	}
	public EmailAlreadyExistException()
	{
		super();
	}
}
