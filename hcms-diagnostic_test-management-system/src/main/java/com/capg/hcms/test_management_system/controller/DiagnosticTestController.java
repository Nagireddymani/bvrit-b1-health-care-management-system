package com.capg.hcms.test_management_system.controller;


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

import com.capg.hcms.test_management_system.model.DiagnosticTest;
import com.capg.hcms.test_management_system.model.DiagnosticTestList;
import com.capg.hcms.test_management_system.service.DiagnosticTestServiceImpl;


@RestController
@RequestMapping("/test")
public class DiagnosticTestController {
	
	@Autowired
	DiagnosticTestServiceImpl service;
	
	@GetMapping("/getalltest")
	public DiagnosticTestList getAlltests(){
		return new DiagnosticTestList(service.getAlltest());
	}
	@GetMapping("/get/id/{testId}")
	public DiagnosticTest getTest(@PathVariable String testId){
		return service.getTest(testId);
	}
	@PostMapping("/addtest")
	public ResponseEntity<DiagnosticTest> addtest(@RequestBody DiagnosticTest test) {
		return new ResponseEntity<DiagnosticTest>(service.addTest(test), HttpStatus.CREATED);
	}
	@DeleteMapping("/removetest/testId/{testId}")
	public boolean removetest(@PathVariable String testId) {
		DiagnosticTest test=getTest(testId);
		return service.removeTest(test);
	}
	
	
}
