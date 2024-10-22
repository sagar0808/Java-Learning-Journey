package com.master.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.main.entities.Student;
import com.master.main.repository.StudentRepository;

@Service
public class ServicesImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Boolean insertStudentDetails(Student student) {
		Boolean status = false;
		try {
			studentRepository.save(student);
			status = true;
			
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Student> readStudentsDetails() {
		
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	public Student getStudentDetailsById(int id) {
		
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Boolean updateStudentById(Student student) {
		Boolean status = false;
		try {
			studentRepository.save(student);
			status = true;
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Boolean deleteStudentDetailsById(int id) {
		Boolean status = false;
		try {
			studentRepository.deleteById(id);;
			status = true;
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}
}
