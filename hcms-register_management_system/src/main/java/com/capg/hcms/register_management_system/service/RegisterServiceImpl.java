package com.capg.hcms.register_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcms.register_management_system.model.User;
import com.capg.hcms.register_management_system.repository.IRegisterRepository;

@Service
public class RegisterServiceImpl implements IRegisterService{

	@Autowired
	private IRegisterRepository registerRepo;
	
	@Override
	public User registerUser(User user) {
		return registerRepo.save(user);
	}

	@Override
	public User getUser(String userId) {
		return registerRepo.getOne(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return registerRepo.findAll();
	}
}
