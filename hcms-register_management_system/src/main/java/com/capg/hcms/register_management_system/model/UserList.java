package com.capg.hcms.register_management_system.model;

import java.util.List;

/*******************************************************************************************************************************
-Author                   :   ManikantaReddy     
-Created/Modified Date    :   
-Description              :   Bean class with List of User Property 

*******************************************************************************************************************************/

public class UserList {

	private List<User> userList;

	public UserList() {
		super();
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public UserList(List<User> userList) {
		super();
		this.userList = userList;
	}
    
	@Override
	public String toString() {
		return "UserList [userList=" + userList + "]";
	}
	
}
