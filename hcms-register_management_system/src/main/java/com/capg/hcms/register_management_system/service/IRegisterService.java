package com.capg.hcms.register_management_system.service;



import com.capg.hcms.register_management_system.model.User;
import com.capg.hcms.register_management_system.model.UserList;

/*******************************************************************************************************************************
-Author                   :    ManikantaReddy 
-Created/Modified Date    :     
-Description              :    

*******************************************************************************************************************************/

public interface IRegisterService {
	
	User registerUser(User user);
	
	User getUser(String userId);
	
	UserList getAllUsers();
	
	User validateUser(String userName,String userPassword); 
	
	boolean removeAllUsers();
}

