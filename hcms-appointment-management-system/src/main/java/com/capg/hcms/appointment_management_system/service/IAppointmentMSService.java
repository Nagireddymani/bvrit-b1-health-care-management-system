package com.capg.hcms.appointment_management_system.service;

import java.util.List;

import com.capg.hcms.appointment_management_system.model.Appointment;


public interface IAppointmentMSService {



	public String makeAppointment(Appointment appointment);
	public Appointment getAppointment(long appointmentId);
	public List<Appointment> getAllAppointments();
	public List<Appointment> findByCenter(String centerId);
	public Appointment approveAppointment(Appointment a);
	
	

}
