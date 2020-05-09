package com.capg.hcms.appointment_management_system.service;

import java.math.BigInteger;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.capg.hcms.appointment_management_system.exceptions.AppointmentAlreadyApprovedException;
import com.capg.hcms.appointment_management_system.exceptions.AppointmentNotFoundException;
import com.capg.hcms.appointment_management_system.model.Appointment;
import com.capg.hcms.appointment_management_system.model.AppointmentList;
import com.capg.hcms.appointment_management_system.repository.IAppointmentMSRepo;

@Service
public class AppointmentMSServiceImp implements IAppointmentMSService {

	@Autowired
	IAppointmentMSRepo appointmentRepo;

	@Override
	public Appointment makeAppointment(Appointment appointment) {
		if(appointmentRepo.getAppointmentByDateTime(appointment.getDateTime())!=null)
			throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED);
		
		return appointmentRepo.save(appointment); 	
	}
	
	@Override
	public Appointment getAppointment(BigInteger appointmentId) {

		if (!appointmentRepo.existsById(appointmentId)) {
			throw new AppointmentNotFoundException("Appointment with id " + appointmentId + "not found");
		}
		return appointmentRepo.getOne(appointmentId);
	}

	@Override
	public AppointmentList getAllAppointments() {
		return new AppointmentList(appointmentRepo.findAll());
	}

	@Override
	public Appointment approveAppointment(Appointment appointment,boolean status) {
	
 		if(appointment.isApproved())
 		{
 		  throw new AppointmentAlreadyApprovedException("Appointment with Id :"+appointment.getAppointmentId()+" is Already Approved");
 		}
 		
		appointment.setApproved(status);
 		return appointmentRepo.save(appointment);
	}


	@Override
	public boolean removeAppointmentById(BigInteger appointmentId) {
		appointmentRepo.deleteById(appointmentId);
		return true;
	}

	@Override
	public boolean removeAllAppointments() {
		appointmentRepo.deleteAll();
		return true;
	}


}
