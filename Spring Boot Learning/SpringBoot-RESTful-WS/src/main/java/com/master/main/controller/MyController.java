package com.master.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.master.main.entities.User;
import com.master.main.services.UserService;

@RestController
public class MyController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User addUserDetails(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/user")
	public List<User> readUserDetails(){
		return userService.readUser();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> readUserData(@PathVariable int id){
		
		User user = userService.readSingleUser(id).orElse(null);
		if(user != null) {
			return ResponseEntity.ok().body(user);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable int id, @RequestBody User user) {
		User updatedUser = userService.updateUser(id, user);
		if (updatedUser != null) {
			return ResponseEntity.ok(updatedUser);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUserDetails(@PathVariable int id) {
		Boolean status = userService.deleteUser(id);
		if (status) {
			return ResponseEntity.ok("User Deleted Successfully...");
		}else {
			return ResponseEntity.ok("User Not Found");
		}
	}
}
