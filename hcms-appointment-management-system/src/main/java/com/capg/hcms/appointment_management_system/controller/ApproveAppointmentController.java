package com.capg.hcms.appointment_management_system.controller;

import java.math.BigInteger;
import java.util.List;

//import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.appointment_management_system.model.Appointment;
import com.capg.hcms.appointment_management_system.model.AppointmentList;
import com.capg.hcms.appointment_management_system.repository.IAppointmentMSRepo;
import com.capg.hcms.appointment_management_system.service.IAppointmentMSService;


@RestController
@RequestMapping("/admin")
public class ApproveAppointmentController {
	  
	     @Autowired
	     IAppointmentMSService service;
	 		
	     @GetMapping("/getAppointment/{appointmentId}")
	     public Appointment getAppointment(@PathVariable BigInteger appointmentId)
	     {
	    	 return service.getAppointment(appointmentId);
	     }
	     

	     @GetMapping("/getallappointments")
	     public AppointmentList getAllAppointment()
	     {
	    	 return service.getAllAppointments();
	     }
	     
	     @PutMapping("/approveAppointment/{appointmentId}/{status}")
	     public Appointment approveAppoinment(@PathVariable BigInteger appointmentId,@PathVariable boolean status)
	     {
	    	 Appointment appointment=service.getAppointment(appointmentId);	  
	    	 return service.approveAppointment(appointment, status);
	     }
			
}
