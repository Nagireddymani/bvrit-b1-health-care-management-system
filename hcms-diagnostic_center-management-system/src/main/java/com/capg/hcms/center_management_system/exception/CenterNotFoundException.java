package com.capg.hcms.center_management_system.exception;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy
-Created/Modified Date    :     27-04-2020
-Description              :     CenterNotFoundException class with constructors

*******************************************************************************************************************************/

public class CenterNotFoundException extends RuntimeException{

	public CenterNotFoundException(String message)
	{
		super(message);
	}
	public CenterNotFoundException()
	{
		super();
	}
	
}
