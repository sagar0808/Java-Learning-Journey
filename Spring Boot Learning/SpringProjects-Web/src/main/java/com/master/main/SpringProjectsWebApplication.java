package com.master.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.master.newPack")
public class SpringProjectsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectsWebApplication.class, args);
		System.out.println("Hello");
	}

}
