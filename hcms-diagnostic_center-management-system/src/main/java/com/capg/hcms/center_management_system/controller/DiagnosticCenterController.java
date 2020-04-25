package com.capg.hcms.center_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public DiagnosticCenter addCenter(@RequestBody DiagnosticCenter center)
	{
		return centerService.addCenter(center);
	}
	
	@DeleteMapping("/delete")
	public boolean removeCenter(@RequestBody DiagnosticCenter center)
	{
		return centerService.removeCenter(center);
	}
	
	@PutMapping("/update")
	public DiagnosticCenter updateCenter(@RequestBody DiagnosticCenter center)
	{
		return centerService.updateCenter(center);
	}
	
}
