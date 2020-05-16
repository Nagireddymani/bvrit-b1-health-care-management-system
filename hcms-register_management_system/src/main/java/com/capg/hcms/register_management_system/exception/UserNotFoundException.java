package com.capg.hcms.register_management_system.exception;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String message)
	{
		super(message);
	}
	public UserNotFoundException()
	{
		super();
	}
}
