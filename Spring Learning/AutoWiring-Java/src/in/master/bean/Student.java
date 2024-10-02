package in.master.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
    private String name;
    private int rollNo;
    @Autowired
    private Contact contact;
    public void setName(String name) {
        this.name = name;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    
    public void display() {
	System.out.println("Name: "+name);
	System.out.println("Roll No: "+rollNo);
	System.out.println("Contact: "+contact);
    }
}
