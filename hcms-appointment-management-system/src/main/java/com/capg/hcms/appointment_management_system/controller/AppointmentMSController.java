package com.capg.hcms.appointment_management_system.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capg.hcms.appointment_management_system.model.Appointment;
import com.capg.hcms.appointment_management_system.service.IAppointmentMSService;

@RestController
@RequestMapping("/appointment")
public class AppointmentMSController {
	
	@Autowired
	RestTemplate resttemplate;

	@Autowired
	IAppointmentMSService service;

	/*
	 * @GetMapping("/centers") public List<DiagnosticCenter> getAllCenters() {
	 * List<DiagnosticCenter> centers = null; return centers;
	 * 
	 * }
	 */

	

	@PostMapping("/add")
	public String makeAppointment(@RequestBody Appointment appointment) {

		
		//String centerid=appointment.getCenterId();
		
		/*
		 * List<Appointment> appointmentList=new ArrayList<Appointment>();
		 * appointmentList.add(appointment);
		 * 
		 * resttemplate.postForObject("", appointmentList, DiagnosticCenter.class);
		 */
		
		

		return service.makeAppointment(appointment);

	}

	@GetMapping("/all")
	public List<Appointment> getAllAppointment() {
		return service.getAllAppointments();
	}
	
	
	
	

}
