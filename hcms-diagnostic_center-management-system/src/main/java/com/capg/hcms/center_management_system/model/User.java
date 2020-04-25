package com.capg.hcms.center_management_system.model;

import java.math.BigInteger;

public class User {

	private String userId;
	private String userName;
	private String userPassword;
	private BigInteger contactNumber;
	private String userEmail;
	private Integer age;
	private String gender;
	
	public User(String userId, String userName, String userPassword, BigInteger contactNumber, String userEmail,
			Integer age, String gender) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.contactNumber = contactNumber;
		this.userEmail = userEmail;
		this.age = age;
		this.gender = gender;
	}

	public User() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public BigInteger getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(BigInteger contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", contactNumber=" + contactNumber + ", userEmail=" + userEmail + ", age=" + age + ", gender="
				+ gender + "]";
	}
	
    	
	
}
