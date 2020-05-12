package com.capg.hcms.appointmentms;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capg.hcms.appointment_management_system.controller.ApproveAppointmentController;
import com.capg.hcms.appointment_management_system.repository.IAppointmentMSRepo;
import com.capg.hcms.appointment_management_system.service.AppointmentMSServiceImp;

class HcmsApproveAppointmentMsApplicationTestsTest {

	@Autowired
	AppointmentMSServiceImp service;
	@Autowired
	IAppointmentMSRepo repo;
	@Autowired
	ApproveAppointmentController approveAppointment;
	@Test
	void testGetAllAppointments() {
		assertEquals(true, !repo.findAll().isEmpty());
	}

	
	/*
	 * @Test void testApproveAppointment() {
	 * 
	 * Appointment appointment =
	 * approveAppointment.approveAppoinment(BigInteger.valueOf(21), true);
	 * 
	 * assertEquals(true, appointment.isApproved());
	 * 
	 * }
	 */
	  
	  @Test void testApproveAppointmentException() {
	  
	  Assertions.assertThrows(LazyInitializationException.class, ()-> {
		  
	  approveAppointment.approveAppoinment(BigInteger.valueOf(1), true);
	  } ); 
	  
	  
	  }
	 
}
