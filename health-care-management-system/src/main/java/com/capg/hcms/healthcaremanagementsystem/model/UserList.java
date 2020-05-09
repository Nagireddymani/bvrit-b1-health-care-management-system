package com.capg.hcms.healthcaremanagementsystem.model;

import java.util.List;

public class UserList {

	private List<User> usersList;

	public UserList() {
		super();
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUserList(List<User> usersList) {
		this.usersList = usersList;
	}

	public UserList(List<User> usersList) {
		super();
		this.usersList = usersList;
	}
    
	@Override
	public String toString() {
		return "UserList [usersList=" + usersList + "]";
	}
	
}
