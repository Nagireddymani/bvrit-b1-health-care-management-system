package com.capg.hcms.register_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.register_management_system.model.User;
import com.capg.hcms.register_management_system.service.IRegisterService;

@RestController
public class RegisterController {

	@Autowired
	private IRegisterService registerService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) 
	{
		return new ResponseEntity<User>(registerService.registerUser(user),HttpStatus.OK);
	}
	
	@GetMapping("/get/id/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId)
	{
		return new ResponseEntity<User>(registerService.getUser(userId),HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUsers()
	{
		return new ResponseEntity<List<User>>(registerService.getAllUsers(),HttpStatus.OK);
	}
	
}
