package com.master.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.master.main.beans.HelloWorld;

@SpringBootApplication
public class SpringBootStandloneDataApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStandloneDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		helloWorld().printHelloWorld("Master");
	}
	
	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}

}
