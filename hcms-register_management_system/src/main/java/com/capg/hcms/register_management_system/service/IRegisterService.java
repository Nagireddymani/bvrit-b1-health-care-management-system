package com.capg.hcms.register_management_system.service;

import java.util.List;

import com.capg.hcms.register_management_system.model.User;

public interface IRegisterService {
	User registerUser(User user);
	
	User getUser(String userId);
	
	List<User> getAllUsers();
}

