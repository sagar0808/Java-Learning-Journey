package com.master.main.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.master.main.entities.Student;
import com.master.main.services.ServicesImpl;

@Component
public class CRUD implements CommandLineRunner{

	@Autowired
	private ServicesImpl servicesImpl;
	
	@Override
	public void run(String... args) throws Exception {
		
		// INSERT	
		Student student = new Student();
		student.setName("Demo");
		student.setRollNo("093");
		student.setMarks(90.48f);
		
		Boolean status = servicesImpl.insertStudentDetails(student);
		if(status) {
			System.out.println("Data Inserted Successfully");
		}else {
			System.out.println("Data Failed to Insert !!!");
		}
		
		// READ
//		Student student = servicesImpl.getStudentDetailsById(3);
//		if (student != null) {
//			System.out.println("Name    : " +student.getName());
//			System.out.println("Roll No : " +student.getRollNo());
//			System.out.println("Marks   : " +student.getMarks());
//		}else {
//			System.out.println("No Data Found With this Id");
//		}
//		
		
		// READALL
//		List<Student> lists = servicesImpl.readStudentsDetails();
//		for (Student student : lists) {
//			System.out.println("Name    : " +student.getName());
//			System.out.println("Roll No : " +student.getRollNo());
//			System.out.println("Marks   : " +student.getMarks());
//			System.out.println("--------------------");
//		}
		
		// UPDATE 
//		Student student = servicesImpl.getStudentDetailsById(3);
//		student.setId(2);
//		Boolean status = servicesImpl.updateStudentById(student);
//		if (status) {
//			System.out.println("Student Data Updated");
//		}else {
//			System.out.println("Student Data Failed to Update !!!");
//		}
		
		// DELETE
//		Boolean status = servicesImpl.deleteStudentDetailsById(6);
//		if (status) {
//			System.out.println("Student Data Updated");
//		}else {
//			System.out.println("Student Data Failed to Update !!!");
//		}
		
	}
}
