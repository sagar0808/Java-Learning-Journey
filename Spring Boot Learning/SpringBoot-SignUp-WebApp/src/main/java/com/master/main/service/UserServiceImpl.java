package com.master.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.master.main.Entity.User;
import com.master.main.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Boolean insertUser(User user) {
		Boolean status = false;
		try {
			userRepository.save(user);
			status = true;
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public User loginUser(String username, String password) {
		User user = userRepository.findByUsername(username);
		
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		
		return user;
	}
	
}
