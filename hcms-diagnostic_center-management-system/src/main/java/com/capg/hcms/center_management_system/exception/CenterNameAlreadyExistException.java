package com.capg.hcms.center_management_system.exception;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy
-Created/Modified Date    :     27-04-2020
-Description              :     CenterNameAlreadyExistException class with constructors

*******************************************************************************************************************************/

public class CenterNameAlreadyExistException extends RuntimeException{

	public CenterNameAlreadyExistException(String message) {
		super(message);
	}
	public CenterNameAlreadyExistException()
	{
		
	}

	
}
