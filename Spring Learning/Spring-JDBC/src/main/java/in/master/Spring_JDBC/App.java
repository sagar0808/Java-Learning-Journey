package in.master.Spring_JDBC;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.master.beans.Student;
import in.master.mappers.StudentMappers;
import in.master.resources.applicationConfig;

public class App {
    public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);

	String name = "";
	int rollNo = 0;
	String contact = "";

	@SuppressWarnings("resource")
	ApplicationContext context = new AnnotationConfigApplicationContext(applicationConfig.class);

	JdbcTemplate template = context.getBean(JdbcTemplate.class);

	try {
//	    insert(template, name, rollNo, contact, scanner);
//	    update(template, name, rollNo, scanner);
//	    delete(template, rollNo, scanner);
//	    read(template);
	    readSingle(template, rollNo, scanner);
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	} finally {
	    scanner.close();
	}
    }

    // Insertion Operation
    public static void insert(JdbcTemplate template, String name, int rollNo, String contact, Scanner scanner)
	    throws SQLException {
	System.out.print("Name : ");
	name = scanner.nextLine();
	System.out.print("Roll No : ");
	rollNo = scanner.nextInt();
	scanner.nextLine();
	System.out.print("Contact : ");
	contact = scanner.nextLine();

	String insertQuery = "INSERT INTO student VALUES(?,?,?)";
	int count = template.update(insertQuery, name, rollNo, contact);

	if (count > 0) {
	    System.out.println("Data Inserted into Table");
	} else {
	    System.out.println("Data cannot Inserted into Table");
	}
    }

    // Updation Operation
    public static void update(JdbcTemplate template, String name, int rollNo, Scanner scanner) throws SQLException {

	System.out.println("----- Update Name by RollNo. -----/n");
	System.out.print("Enter Roll No : ");
	rollNo = scanner.nextInt();
	scanner.nextLine();
	System.out.print("Enter Updated Name : ");
	name = scanner.nextLine();

	String updateQuery = "UPDATE student SET name = ? WHERE rollNo = ?";
	int count = template.update(updateQuery, name, rollNo);

	if (count > 0) {
	    System.out.println("Data Updated Successfully !");
	} else {
	    System.out.println("Data Updation Failed...");
	}
    }

    // Deletion Operation
    public static void delete(JdbcTemplate template, int rollNo, Scanner scanner) throws SQLException {

	System.out.println("----- Delete Student by RollNo. -----/n");
	System.out.print("Enter Roll No : ");
	rollNo = scanner.nextInt();

	String updateQuery = "DELETE FROM student WHERE rollNo = ?";
	int count = template.update(updateQuery, rollNo);

	if (count > 0) {
	    System.out.println("Data Deleted Successfully !");
	} else {
	    System.out.println("Data Cannot Deleted...");
	}
    }

    // Reading All Data Operation
    public static void read(JdbcTemplate template) throws SQLException {

	System.out.println("----- Student Details -----\n");

	String readQuery = "SELECT * FROM student";
	List<Student> student = template.query(readQuery, new StudentMappers());

	for (Student std : student) {
	    System.out.println("Name    : " + std.getName());
	    System.out.println("Roll No : " + std.getRollNo());
	    System.out.println("Contact : " + std.getContact());
	    System.out.println("--------------------------");
	}
    }

    // Reading Single Data Operation
    public static void readSingle(JdbcTemplate template, int rollNo, Scanner scanner) throws SQLException {

	System.out.println("----- Student Details -----\n");

	System.out.print("Roll No. : ");
	rollNo = scanner.nextInt();

	String readQuery = "SELECT * FROM student WHERE rollno = ?";
	Student student = template.queryForObject(readQuery, new StudentMappers(), rollNo);

	System.out.println("Name    : " + student.getName());
	System.out.println("Roll No : " + student.getRollNo());
	System.out.println("Contact : " + student.getContact());
	System.out.println("--------------------------");
    }
}
