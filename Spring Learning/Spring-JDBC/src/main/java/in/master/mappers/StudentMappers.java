package in.master.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.master.beans.Student;

public class StudentMappers implements RowMapper<Student>{

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	
	Student student = new Student();
	
	student.setName(rs.getString("name"));
	student.setRollNo(rs.getInt("rollNo"));
	student.setContact(rs.getString("contact"));
	
	return student;
    }

}
