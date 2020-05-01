package com.capg.hcms.appointment_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.appointment_management_system.exceptions.AppointmentAlreadyApprovedException;
import com.capg.hcms.appointment_management_system.exceptions.AppointmentNotFoundException;

@ControllerAdvice
@RestController
public class AppointmentMSErrorController {
	
	@ExceptionHandler(AppointmentNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Appointment not found",code = HttpStatus.NOT_FOUND)
	public void handleAppointmentNotFoundException() {
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid data entered", code = HttpStatus.BAD_REQUEST)
	public void handleException() {
		
	}
	
	@ExceptionHandler(AppointmentAlreadyApprovedException.class)
	@ResponseStatus(value = HttpStatus.ALREADY_REPORTED, reason = "Appointment Already Approved")
	public void handleAppointmentAlreadyApprovedException() {
		
	}

}
