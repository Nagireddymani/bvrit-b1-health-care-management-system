package com.capg.hcms.register_management_system.service;

import java.util.List;

import com.capg.hcms.register_management_system.model.User;
import com.capg.hcms.register_management_system.model.UserList;

public interface IRegisterService {
	
	User registerUser(User user);
	
	User getUser(String userId);
	
	UserList getAllUsers();
}

