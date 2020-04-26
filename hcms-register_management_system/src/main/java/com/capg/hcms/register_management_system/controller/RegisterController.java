package com.capg.hcms.register_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public User registerUser(@RequestBody User user) 
	{
		return registerService.registerUser(user);
	}
	
	@GetMapping("/get/id/{userId}")
	public User getUser(@PathVariable String userId)
	{
		return registerService.getUser(userId);
	}
	
	@GetMapping("/getall")
	public List<User> getAllUsers()
	{
		return registerService.getAllUsers();
	}
	
}
