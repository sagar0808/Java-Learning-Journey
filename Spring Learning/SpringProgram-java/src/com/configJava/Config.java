package com.configJava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.beans.Student;

@Configuration
public class Config {
    
    @Bean
    public Student std() {
	
	Student std = new Student();
	std.setName("Master");
	std.setRollNo(10);
	std.setEmail("master@gmail.com");
	
	return std;
    }
}
