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

		return "Your appoinment is booked with Appointment ID:" + appointment.getAppointmentId()
				+ "Please wait for approval!";
	}

	@Override
	@Transactional
	public Appointment getAppointment(long appointmentId) {

		if (!appointmentRepo.existsById(appointmentId)) {
			throw new AppointmentNotFoundException("Appointment with id " + appointmentId + "not found");
		}

		return appointmentRepo.getOne(appointmentId);
	}

	@Override
	@Transactional
	public List<Appointment> getAllAppointments() {

		
		return appointmentRepo.findAll();
		
	}

	@Override
	public Appointment approveAppointment(Appointment a) {
		 Appointment ud=appointmentRepo.findById(a.getAppointmentId()).get();
 		if(ud!=null)
 		{
 			ud.setApproved(a.isApproved());
 			ud.setDateTime(a.getDateTime());
 		}
 		return appointmentRepo.save(ud);

	}

	@Override
	@Transactional
	public List<Appointment> findByCenter(String centerId) {

		return appointmentRepo.findByCenter(centerId);
	}

}
