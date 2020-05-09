package com.capg.hcms.appointmentms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.hcms.appointment_management_system.HcmsAppointmentMsApplication;
import com.capg.hcms.appointment_management_system.exceptions.AppointmentNotFoundException;
import com.capg.hcms.appointment_management_system.exceptions.SlotNotAvailableException;
import com.capg.hcms.appointment_management_system.model.Appointment;
import com.capg.hcms.appointment_management_system.repository.IAppointmentMSRepo;
import com.capg.hcms.appointment_management_system.service.IAppointmentMSService;

@SpringBootTest(classes = HcmsAppointmentMsApplication.class)
class HcmsAppointmentMsApplicationTests {

	@Autowired
	IAppointmentMSService service;
	@Autowired
	IAppointmentMSRepo appointmentRepo;
	Appointment appointment;

	@BeforeEach
	public void setUp() {

		appointment = new Appointment("120", BigInteger.valueOf(0), "23", LocalDateTime.of(2020, 5, 24, 9, 30), false);
		
	}

	@Test
	public void testMakeAppointment() {

		Appointment newAppointment=service.makeAppointment(appointment);
		assertEquals(true,service.getAppointment(newAppointment.getAppointmentId())!=null);
		

	}

	@Test
	public void testSlotNotAvailableException() {

		assertThrows(SlotNotAvailableException.class, () -> {
			service.makeAppointment(appointment);
		});

	}
	

	@Test
	public void testAppointmentNotFoundException() {
		assertThrows(AppointmentNotFoundException.class, () -> {
			service.getAppointment(BigInteger.valueOf(12));
		});
	}

}
