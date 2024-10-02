package in.master.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.master.bean.*;
import in.master.resources.applicationConfig;

public class Main {
    public static void main(String[] args) {
	
	@SuppressWarnings("resource")
	ApplicationContext ctx = new AnnotationConfigApplicationContext(applicationConfig.class);

	Student std = (Student) ctx.getBean("stdId");
	std.display();
    }
}
