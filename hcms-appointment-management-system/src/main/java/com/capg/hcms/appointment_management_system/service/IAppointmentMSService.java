package com.capg.hcms.appointment_management_system.service;

import java.util.List;

import com.capg.hcms.appointment_management_system.model.Appointment;

public interface IAppointmentMSService {
	
	public long makeAppointment(Appointment appointment);
	public Appointment getAppointment(long appointmentId);
	public List<Appointment> getAllAppointments();
	
	
	

}
