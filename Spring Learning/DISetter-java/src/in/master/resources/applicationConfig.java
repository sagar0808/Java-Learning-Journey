package in.master.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.master.bean.Contact;
import in.master.bean.Student;

@Configuration
public class applicationConfig {
    
    @Bean
    public Contact contactId() {
	
	Contact contact = new Contact();
	
	contact.setContactName("Master");
	contact.setNumber("986547231");
	
	return contact;
    }
    
    @Bean
    public Student stdId() {
	
	Student student = new Student();
	
	student.setName("Master");
	student.setRollNo(10);
	student.setContact(contactId());
	
	return student;
    }
}
