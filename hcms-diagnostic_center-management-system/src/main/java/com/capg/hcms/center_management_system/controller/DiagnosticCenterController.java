package com.capg.hcms.center_management_system.controller;

import java.math.BigInteger;
import java.util.List;

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

@RestController
@RequestMapping("/center")
public class DiagnosticCenterController {

	@Autowired
	private IDiagnosticCenterService centerService;
	
	@GetMapping("/getallcenters")
	public DiagnosticCenterList getAllCenters()
	{
		return new  DiagnosticCenterList(centerService.getAllCenters());
	}
	
	@GetMapping("/getcenter/center-id/{centerId}")
	public DiagnosticCenter getCenter(@PathVariable String centerId)
	{
		return centerService.getCenter(centerId);
	}
	
	@PostMapping("/addcenter")
	public ResponseEntity<DiagnosticCenter> addCenter(@RequestBody DiagnosticCenter center)
	{
		return new ResponseEntity<DiagnosticCenter>(centerService.addCenter(center),HttpStatus.OK); 
	}
	
	@DeleteMapping("/deletecenter/{centerId}")
	public boolean removeCenter(@PathVariable String centerId)
	{
//		if(centerService.removeCenter(center))
//		      return "Center removed Successfully";
//		else 
//			  return "";
		
		DiagnosticCenter center=getCenter(centerId);
		return centerService.removeCenter(center);
		
	}
	
	@PutMapping("/updatecenter")
	public ResponseEntity<DiagnosticCenter> updateCenter(@RequestBody DiagnosticCenter center)
	{
		return new ResponseEntity<DiagnosticCenter>(centerService.updateCenter(center),HttpStatus.OK);
	}
	
	@PutMapping("/assign/{centerId}/testId/{testId}")
	public DiagnosticCenter assignCenter(@PathVariable String centerId,@PathVariable String testId)
	{
		return centerService.assignCenter(centerId, testId);
	}
	
	@PutMapping("/removeId/{centerId}/testId/{testId}")
	public boolean removeCenterId(@PathVariable String centerId,@PathVariable String testId)
	{
		return centerService.removeCenterId(centerId, testId);
	}
	
	@PutMapping("/assign/{centerId}/appointmentId/{appointmentId}")
	public DiagnosticCenter assignAppointment(@PathVariable String centerId,@PathVariable BigInteger appointmentId)
	{
		return centerService.assignAppointment(centerId, appointmentId);
	}
}
