package com.capg.hcms.appointmentms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.capg.hcms.appointment_management_system.HcmsAppointmentMsApplication;
import com.capg.hcms.appointment_management_system.exceptions.AppointmentNotFoundException;
import com.capg.hcms.appointment_management_system.exceptions.SlotNotAvailableException;
import com.capg.hcms.appointment_management_system.model.Appointment;
import com.capg.hcms.appointment_management_system.service.AppointmentMSServiceImp;
import com.capg.hcms.appointment_management_system.service.IAppointmentMSService;

@SpringBootTest(classes = HcmsAppointmentMsApplication.class)
class HcmsAppointmentMsApplicationTests {

	@Autowired
	IAppointmentMSService service;
	
	Appointment appointment;
	Appointment appointment1;
	Appointment appointment2;
	

	
	@BeforeEach
	public void setUp() {

		appointment = new Appointment("120", BigInteger.valueOf(0), "23", LocalDateTime.of(2020, 6, 20, 9, 30), false);
		appointment1=new Appointment("230", BigInteger.valueOf(0), "12", LocalDateTime.of(2020, 5, 9, 9, 30), false);
		appointment2=new Appointment("230", BigInteger.valueOf(0) , "12", LocalDateTime.of(2020,9 , 9, 11, 30), false);
	}

	//@Test
	//public void testMakeAppointment() {

		//Appointment newAppointment=service.makeAppointment(appointment);
		//assertEquals(true,service.getAppointment(newAppointment.getAppointmentId())!=null);
		

	//}

	@Test
	public void testSlotNotAvailableException() {

		assertThrows(SlotNotAvailableException.class, () -> {service.makeAppointment(appointment);});
		assertThrows(SlotNotAvailableException.class, ()->{service.makeAppointment(appointment1);});
		assertThrows(SlotNotAvailableException.class, ()->{service.makeAppointment(appointment2);});

	}
	

	@Test
	public void testAppointmentNotFoundException() {
		assertThrows(AppointmentNotFoundException.class, () -> {
			service.getAppointment(BigInteger.valueOf(12));
		});
	}

}
