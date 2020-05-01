package com.capg.hcms.appointment_management_system.exceptions;

public class AppointmentAlreadyApprovedException extends RuntimeException {

	public AppointmentAlreadyApprovedException(String message)
	{
		super(message);
	}
}
