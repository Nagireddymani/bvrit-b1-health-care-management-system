package com.capg.hcms.register_management_system.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.register_management_system.model.User;
import com.capg.hcms.register_management_system.model.UserList;
import com.capg.hcms.register_management_system.service.IRegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private IRegisterService registerService;
	
	@PostMapping("/adduser")
	public User registerUser(@RequestBody User user) 
	{
		return registerService.registerUser(user);
	}
	
	@GetMapping("/getuser/user-id/{userId}")
	public User getUser(@PathVariable String userId)
	{
		return registerService.getUser(userId);
	}
	
	@GetMapping("/getallusers")
	public UserList getAllUsers()
	{
		return registerService.getAllUsers();
	}
	
	@GetMapping("/validateuser/username/{userName}/userpassword/{userPassword}")
	public User validateUser(@PathVariable String userName,@PathVariable String userPassword)
	{
		return registerService.validateUser(userName, userPassword);
	}
	
	@DeleteMapping("/removeallusers")
	public String removeAllUsers()
	{
		registerService.removeAllUsers();
		return "All Users Removed";
	}
	
	@DeleteMapping("/removeuser/{userId}")
	public boolean removeUser(@PathVariable String userId)
	{
		return registerService.removeUserById(userId); 
	}
}
