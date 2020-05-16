package com.capg.hcms.register_management_system;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.hcms.register_management_system.exception.ContactNumberAlreadyExistException;
import com.capg.hcms.register_management_system.exception.EmailAlreadyExistException;
import com.capg.hcms.register_management_system.exception.UserNameAlreadyExistException;
import com.capg.hcms.register_management_system.exception.UserNotFoundException;
import com.capg.hcms.register_management_system.model.User;
import com.capg.hcms.register_management_system.repository.IRegisterRepository;
import com.capg.hcms.register_management_system.service.IRegisterService;

@SpringBootTest
class HcmsRegisterManagementSystemApplicationTests {

	@Autowired
	IRegisterRepository repo;

	@Autowired
	IRegisterService service;
	
	User user1;
	User user2;
	User user3;
	
	@BeforeEach
	public void init()
	{	
	   user1=new User("","Dhanush"     ,"IloveIndia1",new BigInteger("9123456789"),"dhanush@gmail.com"     ,"ADMIN",47, "male");   
	   user2=new User("","Surya"     ,"IloveIndia1",new BigInteger("9797979797"),"surya@gmail.com"     ,"ADMIN",47, "male");
	   user3=new User("","Rajesh"     ,"IloveIndia1",new BigInteger("9292929292"),"dhanush@gmail.com"     ,"ADMIN",47, "male");
	}
	
	@Test
	void testRegisterUser() {
		assertEquals(true,service.registerUser(user1)!=null);
	}
	
	@Test
	void testUserNameException()
	{
	    Assertions.assertThrows(UserNameAlreadyExistException.class, ()->
	    {
	    	service.registerUser(user1);
	    });   		  
	}
	
	@Test
	void testContactNumberException()
	{
	    Assertions.assertThrows(ContactNumberAlreadyExistException.class, ()->
	    {
	    	service.registerUser(user2);
	    });		  
	}
	
	@Test
	void testEmailException()
	{
	    Assertions.assertThrows(EmailAlreadyExistException.class, ()->
	    {
	    	service.registerUser(user3);
	    });
	   		  
	}
	
	@Test
	void testValidateUser()
	{
		assertEquals(true,service.validateUser("BoolaRohan","BoolaRohan1@")!=null);
	}
	
	@Test
	void testValidateUserException()
	{
		Assertions.assertThrows(UserNotFoundException.class, ()->
	    {
	    	service.validateUser("BoolaRohan1","BoolaRohan1@");
	    });
	}
	
	@Test
	void testValidateUserException1()
	{
		Assertions.assertThrows(UserNotFoundException.class, ()->
	    {
	    	service.validateUser("BoolaRohan","BoolaRohan@");
	    });
	}
}
