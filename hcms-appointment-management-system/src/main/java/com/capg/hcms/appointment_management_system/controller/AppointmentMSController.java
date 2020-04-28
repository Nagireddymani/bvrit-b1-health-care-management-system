package com.capg.hcms.appointment_management_system.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capg.hcms.appointment_management_system.model.Appointment;
import com.capg.hcms.appointment_management_system.model.DiagnosticCenter;
import com.capg.hcms.appointment_management_system.service.IAppointmentMSService;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping("/appointment")
public class AppointmentMSController {

	@Autowired
	RestTemplate resttemplate;

	
	@Autowired
	IAppointmentMSService service;

	@PostMapping("/add")
	public String makeAppointment(@RequestBody Appointment appointment) {

		return service.makeAppointment(appointment);

	}

	@GetMapping("/id/{appointmentId}")
	public Appointment getAppointment(@PathVariable long appointmentId) {
		return service.getAppointment(appointmentId);
	}

	
	


	@GetMapping("/all")
	public List<Appointment> getAllAppointment() {
		return service.getAllAppointments();
	}

	@GetMapping("/centerid/{centerId}")
	public List<Appointment> findByCenter(@PathVariable String centerId) {
		return service.findByCenter(centerId);
	}

}
