package com.master.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.main.Entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
