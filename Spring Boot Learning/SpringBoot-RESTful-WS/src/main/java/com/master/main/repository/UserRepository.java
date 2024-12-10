package com.master.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.main.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
