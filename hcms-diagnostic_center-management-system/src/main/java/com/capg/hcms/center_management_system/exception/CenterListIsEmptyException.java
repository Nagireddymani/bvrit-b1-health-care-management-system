package com.capg.hcms.center_management_system.exception;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy
-Created/Modified Date    :     27-04-2020
-Description              :     CenterListIsEmptyException class with constructors

*******************************************************************************************************************************/


public class CenterListIsEmptyException extends RuntimeException{

	public CenterListIsEmptyException(String message)
	{
		super(message);
	}
	public CenterListIsEmptyException()
	{
		super();
	}
	
}
