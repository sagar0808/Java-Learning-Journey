package com.master.main.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.master.main.Entities.User;
import com.master.main.repository.DbOperations;

@Component
public class CRUD implements CommandLineRunner {
	
	@Autowired
	private DbOperations operations;

	@Override
	public void run(String... args) throws Exception {
		
		// INSERT
		User user = new User();
		user.setName("Demp");
		user.setEmail("demo@gmail.com");
		user.setPassword("demo@123");
		
		Boolean status = operations.createUser(user);
		if (status) {
			System.out.println("Data Added Successfully");
		}else {
			System.out.println("Data Failed to Add !!!");
		}

		
		// READ
//		User user = operations.getUserById(1);
//		if (user != null) {
//			System.out.println(user.getName());
//			System.out.println(user.getEmail());
//		}

		
		// UPDATE
//		User user = operations.getUserById(1);
//		user.setEmail("master.thedev@gmail.com");
//		Boolean status = operations.updateUserById(user.getId(), user);
//		if(status) {
//			System.out.println("Data Updated Successfully");
//		}else {
//			System.out.println("Data Failed to Update !!!");
//		}

		
		// DELETE
//		User user = operations.getUserById(5);
//		if (user != null) {
//			Boolean status = operations.deleteUserById(user);
//			if (status) {
//				System.out.println("Data Deleted Successfully");
//			} else {
//				System.out.println("Data Failed to Delete !!!");
//			}
//		}else {
//			System.out.println("No Data Found");
//		}
		
	}

}
