package com.capg.hcms.appointment_management_system.service;

import java.math.BigInteger;


import com.capg.hcms.appointment_management_system.model.Appointment;
import com.capg.hcms.appointment_management_system.model.AppointmentList;
/*******************************************************************************************************************************
-Author                   :     Boola Rohan, Rishita Kalidindi
-Created/Modified Date    :     01-05-2020
-Description              :     IAppointmentMSService Interface with services for Appointment Management System
*******************************************************************************************************************************/

public interface IAppointmentMSService {

	Appointment makeAppointment(Appointment appointment);
    Appointment getAppointment(BigInteger appointmentId);
	AppointmentList getAllAppointments();
	Appointment approveAppointment(Appointment appointment,boolean status);
	
	boolean removeAppointmentById(BigInteger appointmentId);
	boolean removeAllAppointments();
}
