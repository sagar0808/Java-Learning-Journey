package com.master.main.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.master.main.beans.Student;

@Configuration
public class Config {

    @Bean
    CommandLineRunner commandLineRunner() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				student1().display();
				System.out.println();
				student2().display();
			}
		};
	}

    @Bean
    Student student1() {
		return new Student("Master", 10, "9654258665");
	}
    
    @Bean
    Student student2() {
		return new Student("Sagar", 11, "8452236955");
	}
}
