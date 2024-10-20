package com.master.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.master.main.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean insert(User user) {
		boolean status = false;
		
		try {
			String insertQuery = "INSERT INTO student VALUES (?,?,?)";
			int count = jdbcTemplate.update(insertQuery, user.getName(), user.getEmail(), user.getCity());
			if (count > 0) {
				status = true;
			}
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean update(User user) {
		boolean status = false;
		
		try {
			String updateQuery = "UPDATE student SET name = ?, city = ? WHERE email = ?";
			int count = jdbcTemplate.update(updateQuery, user.getName(), user.getCity(), user.getEmail());
			if (count > 0) {
				status = true;
			}
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean delete(User user) {
		boolean status = false;
		
		try {
			String deleteQuery = "DELETE FROM student WHERE email = ?";
			int count = jdbcTemplate.update(deleteQuery, user.getEmail());
			if(count > 0) {
				status = true;
			}
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		
		return false;
	}
	
	public User Read(String email) {
		String readQuery = "SELECT * FROM student WHERE email = ?";
		return jdbcTemplate.queryForObject(readQuery, new rowMap(), email);
	}
	
	public List<User> readAll(){
		String readAllQuery = "SELECT * FROM student";
		return jdbcTemplate.query(readAllQuery, new rowMap());
	}
	
	public static final class rowMap implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			User user = new User();
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setCity(rs.getString("city"));
			
			return user;
		}
	}
}
