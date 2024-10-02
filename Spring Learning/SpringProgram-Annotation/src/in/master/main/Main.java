package in.master.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.master.annotation.Config;
import in.master.bean.Student;

public class Main {
    public static void main(String[] args) {
	
	@SuppressWarnings("resource")
	ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
	
	Student student = (Student) context.getBean("std");
	student.display();
    }
}
