package in.master.Spring_JDBC;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

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

	NamedParameterJdbcTemplate template = context.getBean(NamedParameterJdbcTemplate.class);

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
    public static void insert(NamedParameterJdbcTemplate template, String name, int rollNo, String contact, Scanner scanner)
	    throws SQLException {
	System.out.print("Name : ");
	name = scanner.nextLine();
	System.out.print("Roll No : ");
	rollNo = scanner.nextInt();
	scanner.nextLine();
	System.out.print("Contact : ");
	contact = scanner.nextLine();
	
	Map<String, Object> map = new HashMap<>();
	map.put("key_name", name);
	map.put("key_rollno", rollNo);
	map.put("key_contact", contact);

	String insertQuery = "INSERT INTO npjt VALUES(:key_name, :key_rollno, :key_contact)";
	int count = template.update(insertQuery, map);

	if (count > 0) {
	    System.out.println("Data Inserted into Table");
	} else {
	    System.out.println("Data cannot Inserted into Table");
	}
    }

    // Updation Operation
    public static void update(NamedParameterJdbcTemplate template, String name, int rollNo, Scanner scanner) throws SQLException {

	System.out.println("----- Update Name by RollNo. -----/n");
	System.out.print("Enter Roll No : ");
	rollNo = scanner.nextInt();
	scanner.nextLine();
	System.out.print("Enter Updated Name : ");
	name = scanner.nextLine();
	
	Map<String, Object> map = new HashMap<>();
	map.put("key_name", name);
	map.put("key_rollno", rollNo);

	String updateQuery = "UPDATE npjt SET name = :key_name WHERE rollNo = :key_rollno";
	int count = template.update(updateQuery, map);

	if (count > 0) {
	    System.out.println("Data Updated Successfully !");
	} else {
	    System.out.println("Data Updation Failed...");
	}
    }

    // Deletion Operation
    public static void delete(NamedParameterJdbcTemplate template, int rollNo, Scanner scanner) throws SQLException {

	System.out.println("----- Delete Student by RollNo. -----\n");
	System.out.print("Enter Roll No : ");
	rollNo = scanner.nextInt();
	
	Map<String, Object> map = new HashMap<>();
	map.put("key_rollno", rollNo);

	String updateQuery = "DELETE FROM npjt WHERE rollNo = :key_rollno";
	int count = template.update(updateQuery, map);

	if (count > 0) {
	    System.out.println("Data Deleted Successfully !");
	} else {
	    System.out.println("Data Cannot Deleted...");
	}
    }

    // Reading All Data Operation
    public static void read(NamedParameterJdbcTemplate template) throws SQLException {

	System.out.println("----- Student Details -----\n");

	String readQuery = "SELECT * FROM npjt";
	List<Student> student = template.query(readQuery, new StudentMappers());

	for (Student std : student) {
	    System.out.println("Name    : " + std.getName());
	    System.out.println("Roll No : " + std.getRollNo());
	    System.out.println("Contact : " + std.getContact());
	    System.out.println("--------------------------");
	}
    }

    // Reading Single Data Operation
    public static void readSingle(NamedParameterJdbcTemplate template, int rollNo, Scanner scanner) throws SQLException {

	System.out.println("----- Student Details -----\n");

	System.out.print("Roll No. : ");
	rollNo = scanner.nextInt();
	
	Map<String, Object> map = new HashMap<>();
	map.put("key_rollno", rollNo);

	String readQuery = "SELECT * FROM npjt WHERE rollno = :key_rollno";
	Student student = template.queryForObject(readQuery, map, new StudentMappers());

	System.out.println("Name    : " + student.getName());
	System.out.println("Roll No : " + student.getRollNo());
	System.out.println("Contact : " + student.getContact());
	System.out.println("--------------------------");
    }
}
