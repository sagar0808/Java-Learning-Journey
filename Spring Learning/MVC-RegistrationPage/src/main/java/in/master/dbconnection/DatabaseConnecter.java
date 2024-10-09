package in.master.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnecter {
    
    public static Connection connect() throws SQLException {
	
	Connection connection = null;
	
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvc","root", "root");

	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	
	return connection;
    }
}
