package in.master.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.master.bean.*;

public class Main {
    public static void main(String[] args) {
	String conf = "/in/master/resources/applicationContext.xml";
	@SuppressWarnings("resource")
	ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);

	Student std = (Student) ctx.getBean("stdId");
	std.display();
    }
}
