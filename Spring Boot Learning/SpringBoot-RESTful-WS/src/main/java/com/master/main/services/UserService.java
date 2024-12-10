package com.master.main.services;

import java.util.List;
import java.util.Optional;

import com.master.main.entities.User;

public interface UserService {
	public User createUser(User user);
	public List<User> readUser();
	public Optional<User> readSingleUser(int id);
	public User updateUser(int id, User user);
	public Boolean deleteUser(int id);
}
