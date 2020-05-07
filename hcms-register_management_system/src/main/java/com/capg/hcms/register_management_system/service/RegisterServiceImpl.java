package com.capg.hcms.register_management_system.service;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcms.register_management_system.exception.ContactNumberAlreadyExistException;
import com.capg.hcms.register_management_system.exception.EmailAlreadyExistException;
import com.capg.hcms.register_management_system.exception.UserNameAlreadyExistException;
import com.capg.hcms.register_management_system.exception.UserNotFoundException;
import com.capg.hcms.register_management_system.model.User;
import com.capg.hcms.register_management_system.model.UserList;
import com.capg.hcms.register_management_system.repository.IRegisterRepository;

@Service
public class RegisterServiceImpl implements IRegisterService{

	@Autowired
	private IRegisterRepository registerRepo;
	@Autowired
	private Random random;
	
	@Override
	public User registerUser(User user) {
		
		user.setUserId(Integer.toString(random.nextInt(1000000)));
		
		if(registerRepo.getUserByUserName(user.getUserName())!=null)
			throw new UserNameAlreadyExistException("User with Name "+user.getUserName()+" is Already Exist");
		
		if(registerRepo.getUserByContactNumber(user.getContactNumber())!=null)
			throw new ContactNumberAlreadyExistException("User with ContactNumber "+user.getContactNumber()+" is Already Exist");
		
		if(registerRepo.getUserByUserEmail(user.getUserEmail())!=null)
			throw new EmailAlreadyExistException("User with Email "+user.getUserEmail()+" is Already Exist");
	
		return registerRepo.save(user);
	}

	@Override
	public User getUser(String userId) {
		if(!registerRepo.existsById(userId))
			throw new UserNotFoundException("User with id "+userId+" Not Found");
		return registerRepo.getOne(userId);
	}

	@Override
	public UserList getAllUsers() {
		return new UserList(registerRepo.findAll());
	}

	@Override
	public User validateUser(String userName, String userPassword) {
        
		User user;
		try {
	       user=registerRepo.getUserByUserName(userName);
        }
        catch(NullPointerException e)
        {
        	throw new UserNotFoundException("Invalid UserName");
        }
		System.out.println(user);
		System.out.println(user.getUserPassword());
		System.out.println(userPassword);
		System.out.println(user.getUserPassword().equals(userPassword));
        if( user!=null  && user.getUserPassword().equals(userPassword))
			return user;
        else
        	throw new UserNotFoundException("Invalid Password");
	}

	@Override
	public boolean removeAllUsers() {
		registerRepo.deleteAll();
		return true;
	}
}
