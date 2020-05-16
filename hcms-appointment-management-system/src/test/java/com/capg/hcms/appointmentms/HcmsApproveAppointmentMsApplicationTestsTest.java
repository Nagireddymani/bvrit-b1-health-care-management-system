package com.capg.hcms.appointmentms;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.hcms.appointment_management_system.HcmsAppointmentMsApplication;
import com.capg.hcms.appointment_management_system.controller.ApproveAppointmentController;
import com.capg.hcms.appointment_management_system.repository.IAppointmentMSRepo;
import com.capg.hcms.appointment_management_system.service.AppointmentMSServiceImp;

@SpringBootTest(classes = HcmsAppointmentMsApplication.class)
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

	

	@Test
	void testApproveAppointmentException() {

		Assertions.assertThrows(LazyInitializationException.class, () -> {

			approveAppointment.approveAppoinment(BigInteger.valueOf(1), true);
		});

	}

}
