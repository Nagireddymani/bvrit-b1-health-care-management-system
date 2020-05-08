package com.capg.hcms.test_management_system.exception;

/*******************************************************************************************************************************
-Author                   :     Ashritha
-Created/Modified Date    :     1/05/2020
-Description              :     TestNotFoundException is thrown when the admin tries to get the test that is not present in the database.
*******************************************************************************************************************************/

public class TestNotFoundException extends RuntimeException{
	
	public TestNotFoundException(String message) {
		super(message);
	}

}
