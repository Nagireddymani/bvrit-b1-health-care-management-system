package com.capg.hcms.appointment_management_system.controller;

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
import com.capg.hcms.appointment_management_system.service.IAppointmentMSService;


@RestController
@RequestMapping("/admin")
public class ApproveAppointmentController {
	
	 @Autowired
	 IAppointmentMSService appointmentMSService;
	 
		
	
	     @GetMapping(value="/getAppointment/{appointmentId}",produces="application/json")
	     public Appointment getAppointment(@PathVariable int appointment_id)
	     {
	    	 return appointmentMSService.getAppointment(appointment_id);
	     }
	     

	     @GetMapping(value="/getAllAppointments",produces="application/json")
	     public List<Appointment> getAllAppointment()
	     {
	    	 return appointmentMSService.getAllAppointments();
	     }
	    
	     
	     @PutMapping("/approveAppointment")
	     public Appointment approveAppoinment(@RequestBody Appointment appointment)
	     {
	    	 Appointment a=appointmentMSService.approveAppointment(appointment);
	    	 return a;
	     }
	     
			/*
			 * public List<Appointment> approveAppointment(@PathVariable String centerId) {
			 * 
			 * DiagnosticCenter center=rt.getFor return
			 * appointmentMSService.getAllAppointments(); }
			 */
	     
	     
	     
	     
		
			    

}
