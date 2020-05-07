package com.capg.hcms.center_management_system.controller;

import java.math.BigInteger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.center_management_system.model.DiagnosticCenter;
import com.capg.hcms.center_management_system.model.DiagnosticCenterList;
import com.capg.hcms.center_management_system.service.IDiagnosticCenterService;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy
-Created/Modified Date    :     01-05-2020
-Description              :     DiagnosticCenterController Class for accessing DiagnosticCenter Management System services

*******************************************************************************************************************************/

@RestController
@RequestMapping("/center")
public class DiagnosticCenterController {

	@Autowired
	private IDiagnosticCenterService centerService;
	
	@GetMapping("/getallcenters")
	public ResponseEntity<DiagnosticCenterList> getAllCenters()
	{
		DiagnosticCenterList centerList=centerService.getAllCenters();
		if(centerList==null)
	    	return new ResponseEntity<DiagnosticCenterList>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<DiagnosticCenterList>(centerList,HttpStatus.OK);
			
	}
	
	@GetMapping("/getcenter/center-id/{centerId}")
	public DiagnosticCenter getCenter(@PathVariable String centerId)
	{
		return centerService.getCenterById(centerId);
	}
	
	@PostMapping("/addcenter")
	public ResponseEntity<DiagnosticCenter> addCenter(@RequestBody DiagnosticCenter center)
	{
		DiagnosticCenter newcenter=centerService.addCenter(center);
		//if(newcenter!=null)
	     	return new ResponseEntity<DiagnosticCenter>(center,HttpStatus.CREATED); 
	     //return new ResponseEntity<DiagnosticCenter>(HttpStatus.ALREADY_REPORTED);
	
	}
	
	@DeleteMapping("/removecenter/center-id/{centerId}")
	public String removeCenter(@PathVariable String centerId)
	{
		DiagnosticCenter center=getCenter(centerId);
		if(centerService.removeCenter(center));
		     return "Center Deleted Successfully";
	}
	
	@PutMapping("/assign-testid/{centerId}/test-id/{testId}")
	public DiagnosticCenter assignTestId(@PathVariable String centerId,@PathVariable String testId)
	{
		return centerService.assignTestId(centerId, testId);
	}
	
	@PutMapping("/remove-testid/{centerId}/test-id/{testId}")
	public boolean removeTestId(@PathVariable String centerId,@PathVariable String testId)
	{
		return centerService.removeTestId(centerId, testId);
	}
	
	@PutMapping("/assign-appointmentid/{centerId}/appointment-id/{appointmentId}")
	public DiagnosticCenter assignAppointment(@PathVariable String centerId,@PathVariable BigInteger appointmentId)
	{
		return centerService.assignAppointmentId(centerId, appointmentId);
	}
	
	@DeleteMapping("removeallcenters")
	public String removeAllCenters() 
	{
		centerService.removeAllCenters();
			return "All Center Removed";
	}
}
