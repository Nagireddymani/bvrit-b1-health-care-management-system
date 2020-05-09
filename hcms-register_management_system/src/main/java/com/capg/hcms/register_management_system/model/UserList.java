package com.capg.hcms.register_management_system.model;

import java.util.List;

/*******************************************************************************************************************************
-Author                   :   ManikantaReddy     
-Created/Modified Date    :   
-Description              :   Bean class with List of User Property 

*******************************************************************************************************************************/

public class UserList {

	private List<User> usersList;

	public UserList() {
		super();
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	public UserList(List<User> userList) {
		super();
		this.usersList = userList;
	}
    
	@Override
	public String toString() {
		return "UsersList [userList=" + usersList + "]";
	}
	
}
