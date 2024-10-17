package com.master.main.beans;

public class Student {
	private String name;
	private int rollNo;
	private String contact;
	
	public Student(String name, int rollNo, String contact) {
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public void display() {
		System.out.println("Name : " + name);
		System.out.println("Roll No : " + rollNo);
		System.out.println("Contact : " + contact);
	}
	
}
