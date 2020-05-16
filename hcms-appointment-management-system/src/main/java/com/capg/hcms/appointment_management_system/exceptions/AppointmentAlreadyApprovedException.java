package com.capg.hcms.appointment_management_system.exceptions;

/*******************************************************************************************************************************
-Author                   :     Boola Rohan
-Created/Modified Date    :     27-04-2020
-Description              :     AppointmentAlreadyApprovedException class to handle runtime exception
*******************************************************************************************************************************/

public class AppointmentAlreadyApprovedException extends RuntimeException {

	public AppointmentAlreadyApprovedException(String message)
	{
		super(message);
	}
}
