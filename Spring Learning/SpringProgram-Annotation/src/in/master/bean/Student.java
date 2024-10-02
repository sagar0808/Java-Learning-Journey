package in.master.bean;

import org.springframework.stereotype.Component;

@Component("std")
public class Student {
    private String name = "Master";
    private int rollNo = 10;
    private String contact = "9875632";

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Contact: " + contact);
    }
}
