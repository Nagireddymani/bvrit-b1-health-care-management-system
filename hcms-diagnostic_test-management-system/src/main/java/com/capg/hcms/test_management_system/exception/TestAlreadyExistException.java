package com.capg.hcms.test_management_system.exception;

/*******************************************************************************************************************************
-Author                   :     Ashritha
-Created/Modified Date    :     1/05/2020
-Description              :     TestAlreadyExistException is thrown when the admin tries to add the test that is already present.
*******************************************************************************************************************************/

public class TestAlreadyExistException extends RuntimeException{
	
	public TestAlreadyExistException(String message) {
		super(message);
	}

}
