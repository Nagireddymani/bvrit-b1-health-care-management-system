package com.capg.hcms.appointment_management_system.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcms.appointment_management_system.exceptions.AppointmentAlreadyApprovedException;
import com.capg.hcms.appointment_management_system.exceptions.AppointmentNotFoundException;
import com.capg.hcms.appointment_management_system.exceptions.SlotNotAvailableException;
import com.capg.hcms.appointment_management_system.model.Appointment;
import com.capg.hcms.appointment_management_system.model.AppointmentList;
import com.capg.hcms.appointment_management_system.repository.IAppointmentMSRepo;

/*******************************************************************************************************************************
-Author                   :     Boola Rohan, Rishita Kalidindi
-Created/Modified Date    :     01-05-2020
-Description              :     AppointmentMSServiceImp Class implements services for Appointment Management System
*******************************************************************************************************************************/



@Service
public class AppointmentMSServiceImp implements IAppointmentMSService {

	@Autowired
	IAppointmentMSRepo appointmentRepo;
	
	/*******************************************************************************************************************************
	-Function Name            :     makeAppointment
	-Input Parameters         :     Appointment Object
	-Return Type              :     appointment object
	-Throws                   :     SlotNotAvailableException
	-Author                   :     Rishita Kalididni
	-Created/Modified Date    :     04-05-2020
	-Description              :     adding appointment to the appointment database table 
	*******************************************************************************************************************************/

	@Override
	public Appointment makeAppointment(Appointment appointment) {
		
		LocalTime time=appointment.getDateTime().toLocalTime();
		
	    if (appointmentRepo.getAppointmentByDateTime(appointment.getDateTime()) != null || appointment.getDateTime().isBefore(LocalDateTime.now().plusHours(1))||
				appointment.getDateTime().isAfter(LocalDateTime.now().plusMonths(3))||time.isBefore(LocalTime.of(7, 0))||time.isAfter(LocalTime.of(9, 30))) 
	    {
			throw new SlotNotAvailableException("This slot is not available");
		}
		return appointmentRepo.save(appointment);
	}
	
	/*******************************************************************************************************************************
	-Function Name            :     getAppointment
	-Input Parameters         :     BigInteger appointmentId 
	-Return Type              :     Appointment Object
	-Throws                   :     AppointmentNotFoundException
	-Author                   :     Rishita Kalidindi
	-Created/Modified Date    :     4-05-2020
	-Description              :     getting appointment based on appointmentId from appointment dataBase table
	*******************************************************************************************************************************/

	@Override
	public Appointment getAppointment(BigInteger appointmentId) {

		if (!appointmentRepo.existsById(appointmentId)) {
			throw new AppointmentNotFoundException("Appointment with id " + appointmentId + "not found");
		}
		return appointmentRepo.getOne(appointmentId);
	}

	@Override
	public AppointmentList getAllAppointments() {

		if (appointmentRepo.findAll().isEmpty()) {
			throw new AppointmentNotFoundException("Appointment list is empty");
		}
		return new AppointmentList(appointmentRepo.findAll());
	}

	@Override
	public Appointment approveAppointment(Appointment appointment, boolean status) {

		if (appointment.isApproved()) {
			throw new AppointmentAlreadyApprovedException(
					"Appointment with Id :" + appointment.getAppointmentId() + " is Already Approved");
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
