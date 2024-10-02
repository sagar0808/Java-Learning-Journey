package in.master.bean;

public class Student {
    private String name;
    private int rollNo;
    private Contact contact;
    public void setName(String name) {
        this.name = name;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
    public void display() {
	System.out.println("Name: "+name);
	System.out.println("Roll No: "+rollNo);
	System.out.println("Contact: "+contact);
    }
}
