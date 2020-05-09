package com.capg.hcms.appointment_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.appointment_management_system.exceptions.AppointmentAlreadyApprovedException;

import com.capg.hcms.appointment_management_system.exceptions.AppointmentNotFoundException;
import com.capg.hcms.appointment_management_system.exceptions.SlotNotAvailableException;
/*******************************************************************************************************************************
-Author                   :     Boola Rohan, Rishita Kalidindi
-Created/Modified Date    :     01-05-2020
-Description              :     AppointmentMSErrorController Class for handling Appointment Management System Exceptions
*******************************************************************************************************************************/


@ControllerAdvice
@RestController
public class AppointmentMSErrorController {

	@ExceptionHandler(AppointmentNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Appointment not found", code = HttpStatus.NOT_FOUND)
	public void handleAppointmentNotFoundException() {

		//To handle Appointment not found exception
	}
	
	@ExceptionHandler(SlotNotAvailableException.class)
	@ResponseStatus(value = HttpStatus.ALREADY_REPORTED,reason = "This slot is not available",code=HttpStatus.ALREADY_REPORTED)
	public void handleSlotNotAvailableException() {
		//To handle slot not available exception
	}

	@ExceptionHandler(AppointmentAlreadyApprovedException.class)
	@ResponseStatus(value = HttpStatus.ALREADY_REPORTED, reason = "Appointment Already Approved")
	public void handleAppointmentAlreadyApprovedException() {

		//To handle Appointment already approved exception
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You have entered invalid data", code = HttpStatus.BAD_REQUEST)
	public void handleInvalidData() {

		//To handle bad requests
	}

}
