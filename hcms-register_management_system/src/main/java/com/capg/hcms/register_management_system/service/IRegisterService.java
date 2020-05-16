package com.capg.hcms.register_management_system.service;



import com.capg.hcms.register_management_system.model.User;
import com.capg.hcms.register_management_system.model.UserList;

/*******************************************************************************************************************************
-Author                   :    ManikantaReddy 
-Created/Modified Date    :    16-05-2020
-Description              :    Service Interface for Register Management System

*******************************************************************************************************************************/

public interface IRegisterService {
	
	User registerUser(User user);
	
	User getUser(String userId);
	
	UserList getAllUsers();
	
	User validateUser(String userName,String userPassword); 
	
	boolean removeAllUsers();
	
	boolean removeUserById(String userId);
}

