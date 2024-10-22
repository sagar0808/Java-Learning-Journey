package com.master.main.services;

import java.util.List;

import com.master.main.entities.Student;

public interface StudentService {
	public Boolean insertStudentDetails(Student student);
	public List<Student> readStudentsDetails();
	public Student getStudentDetailsById(int id);
	public Boolean updateStudentById(Student student);
	public Boolean deleteStudentDetailsById(int id);
}
