package com.master.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.main.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{


}
