package com.capg.hcms.appointment_management_system.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcms.appointment_management_system.dao.IAppointmentMSRepo;
import com.capg.hcms.appointment_management_system.exceptions.AppointmentNotFoundException;
import com.capg.hcms.appointment_management_system.model.Appointment;


@Service
public class AppointmentMSServiceImp implements IAppointmentMSService {

	@Autowired
	IAppointmentMSRepo appointmentRepo;

	@Override
	public String makeAppointment(Appointment appointment) {
		appointmentRepo.save(appointment);
		return "Your appoinment is booked and your Appointment ID is:"+appointment.getAppointmentId()+". Please wait for approval!";
	}

	@Override
	public Appointment getAppointment(long appointmentId) {
		
		if(!appointmentRepo.existsById(appointmentId)) {
			throw new AppointmentNotFoundException("Appointment with id "+appointmentId+"not found");
		}
		
		return appointmentRepo.getOne(appointmentId);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		
		return appointmentRepo.findAll();
	}

	
	@Override
    @Transactional
	public List<Appointment> findByCenter(String centerId) {
		
		return appointmentRepo.findByCenter(centerId);
	}

	
}
