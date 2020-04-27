package com.capg.hcms.center_management_system.controller;

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
import com.capg.hcms.center_management_system.service.IDiagnosticCenterService;

@RestController
@RequestMapping("/center")
public class DiagnosticCenterController {

	@Autowired
	private IDiagnosticCenterService centerService;
	
	
	@GetMapping("/getall")
	public List<DiagnosticCenter> getAllCenters()
	{
		return centerService.getAllCenters();
	}
	
	@GetMapping("/get/id/{centerId}")
	public DiagnosticCenter getCenter(@PathVariable String centerId)
	{
		return centerService.getCenter(centerId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<DiagnosticCenter> addCenter(@RequestBody DiagnosticCenter center)
	{
		return new ResponseEntity<DiagnosticCenter>(centerService.addCenter(center),HttpStatus.OK); 
	}
	
	@DeleteMapping("/delete")
	public boolean removeCenter(@RequestBody DiagnosticCenter center)
	{
		return centerService.removeCenter(center);
	}
	
	@PutMapping("/update")
	public ResponseEntity<DiagnosticCenter> updateCenter(@RequestBody DiagnosticCenter center)
	{
		return new ResponseEntity<DiagnosticCenter>(centerService.updateCenter(center),HttpStatus.OK);
	}
	
}
