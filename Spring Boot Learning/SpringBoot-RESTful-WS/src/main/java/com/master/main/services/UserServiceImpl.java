package com.master.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.main.entities.User;
import com.master.main.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<User> readUser() {
		
		return userRepository.findAll();
	}

	@Override
	public Optional<User> readSingleUser(int id) {
		
		return userRepository.findById(id);
	}

	@Override
	public User updateUser(int id, User newUser) {
		User user = userRepository.findById(id).orElse(null);
		if(user != null) {
			return userRepository.save(newUser);
		}else {
			throw new RuntimeException("User not Found "+ id);
		}
	}

	@Override
	public Boolean deleteUser(int id) {
		User user = userRepository.findById(id).orElse(null);
		if (user != null) {
			userRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

}
