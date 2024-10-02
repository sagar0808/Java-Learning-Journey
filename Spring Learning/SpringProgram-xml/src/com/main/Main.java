package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Student;

public class Main {
    public static void main(String[] args) {
	String conf = "com/config/applicationContext.xml";
	@SuppressWarnings("resource")
	ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);

	Student std = (Student) ctx.getBean("stdId");
	std.display();

	Student std2 = (Student) ctx.getBean("std2");
	std2.display();
    }
}
