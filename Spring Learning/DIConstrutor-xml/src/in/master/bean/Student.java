package in.master.bean;

public class Student {
    private String name;
    private int rollNo;
    private Contact contact;
    
    public Student(String name, int rollNo, Contact contact) {
	super();
	this.name = name;
	this.rollNo = rollNo;
	this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public Contact getContact() {
        return contact;
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
