package in.master.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.master.bean.Contact;
import in.master.bean.Student;

@Configuration
public class applicationConfig {
    
    @Bean
    public Contact contactId() {
	
	Contact contact = new Contact("Master", "4569857412");
	
	return contact;
    }
    
    @Bean
    public Student stdId() {
	
	Student student = new Student("Master", 10, contactId());
	
	return student;
    }
}
