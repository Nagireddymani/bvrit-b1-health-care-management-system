package com.capg.hcms.appointment_management_system.service;

import java.math.BigInteger;
import java.util.List;

import com.capg.hcms.appointment_management_system.model.Appointment;
import com.capg.hcms.appointment_management_system.model.AppointmentList;


public interface IAppointmentMSService {

	Appointment makeAppointment(Appointment appointment);
    Appointment getAppointment(BigInteger appointmentId);
	AppointmentList getAllAppointments();
	Appointment approveAppointment(Appointment appointment,boolean status);
	
	boolean removeAppointmentById(BigInteger appointmentId);
	boolean removeAllAppointments();
}
