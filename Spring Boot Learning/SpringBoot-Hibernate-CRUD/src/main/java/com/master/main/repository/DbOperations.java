package com.master.main.repository;

import com.master.main.Entities.User;

public interface DbOperations {
	public Boolean createUser(User user);
	public User getUserById(int id);
	public Boolean updateUserById(int id, User user);
	public Boolean deleteUserById(User user);
}
