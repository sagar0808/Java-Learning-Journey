package com.master.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.master.main.dao.UserDao;
import com.master.main.entity.User;

@SpringBootApplication
public class SpringBootJdbcCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcCrudApplication.class, args);
	}
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user = new User("Sagar", "sagar@96596", "Ara");
		
		
		// INSERT
//		Boolean status = userDao.insert(user);
//		if (status) {
//			System.out.println("Data Inserted Successfully");
//		}else {
//			System.out.println("Data Insertion Failed !!!");
//		}
		
		// UPDATE
//		Boolean status = userDao.update(user);
//		if (status) {
//			System.out.println("Data Updated Successfully");
//		}else {
//			System.out.println("Data Updation Failed !!!");
//		}
		
		// DELETE
//		Boolean status = userDao.delete(user);
//		if (status) {
//			System.out.println("Data Deleted Successfully");
//		}else {
//			System.out.println("Data Deletion Failed !!!");
//		}
		
		// READ BY EMAIL
//		User user2 = userDao.Read("master@235");
//		System.out.println(user2.getName());
//		System.out.println(user2.getEmail());
//		System.out.println(user2.getCity()); 
		
		// READ ALL
		List<User> users = userDao.readAll();
		for (User list : users) {
			System.out.println(list.getName());
			System.out.println(list.getEmail());
			System.out.println(list.getCity()); 
			System.out.println("----------------");
		}
	}

}
