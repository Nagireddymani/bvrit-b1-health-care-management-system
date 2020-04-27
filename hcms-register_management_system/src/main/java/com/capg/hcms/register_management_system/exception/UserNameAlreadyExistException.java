package com.capg.hcms.register_management_system.exception;

public class UserNameAlreadyExistException extends RuntimeException{

	public UserNameAlreadyExistException(String message)
	{
		super(message);
	}
	public UserNameAlreadyExistException()
	{
		super();
	}
}
