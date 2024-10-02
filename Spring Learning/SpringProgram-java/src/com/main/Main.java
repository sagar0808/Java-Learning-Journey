package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beans.Student;
import com.configJava.Config;

public class Main {
    public static void main(String[] args) {
	
	@SuppressWarnings("resource")
	ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
	
	Student sd = (Student) ctx.getBean("std");
	sd.display();
	
    }
}
