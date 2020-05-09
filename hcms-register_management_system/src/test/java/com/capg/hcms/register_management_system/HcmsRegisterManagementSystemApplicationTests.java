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
	User user4;
	
	@BeforeEach
	public void init()
	{
	   user1=new User("","Dhanush"     ,"IloveIndia1",new BigInteger("9123456789"),"dhanush@gmail.com"     ,"ADMIN",47, "male");
	   user2=new User("","SuryaPrakash","IloveIndia1",new BigInteger("9123456789"),"suryaprakash@gmail.com","ADMIN",47, "male");   
	   user3=new User("","DhanushKoti" ,"IloveIndia1",new BigInteger("9999999999"),"krishna@gmail.com"     ,"ADMIN",47, "male");
	   user4=new User("","Krishna"     ,"IloveIndia1",new BigInteger("9777777779"),"krishna@gmail.com"     ,"ADMIN",47, "male");
	}
	
//	@Test
//	void testRegisterUser() {
//		 service.registerUser(user4);
//		 assertEquals(true,repo.getUserByUserName("Dhanush")!=null);
//	}
	
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
	
//	@Test
//	void testEmailException()
//	{
//	    Assertions.assertThrows(EmailAlreadyExistException.class, ()->
//	    {
//	    	service.registerUser(user3);
//	    });
//	   		  
//	}
	
}
