package com.master.main.service;

import com.master.main.Entity.User;

public interface UserService {
	public Boolean insertUser(User user);
	public User loginUser(String userName, String password);
}
