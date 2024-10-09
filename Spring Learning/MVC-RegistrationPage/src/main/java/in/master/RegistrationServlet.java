package in.master;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.master.dbconnection.DatabaseConnecter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	PrintWriter out = resp.getWriter();
	resp.setContentType("text/html");
        
	String name = req.getParameter("name");
	String email = req.getParameter("email");
	String pass = req.getParameter("pass");
	
	try {
	    Connection connection = DatabaseConnecter.connect();
	    
	    String insert = "INSERT INTO studentdata VALUES(?,?,?)";
	    PreparedStatement ppsmt = connection.prepareStatement(insert);
	    ppsmt.setString(1, email);
	    ppsmt.setString(2, pass);
	    ppsmt.setString(3, name);
	    
	    int count = ppsmt.executeUpdate();
	    
	    if(count > 0) {
		System.out.println("Registration Successfully");
		out.print("<h3> Registered Successfull </h3>");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
		requestDispatcher.include(req, resp);
		
	    }else {
		System.out.println("Didn't Registred !");
		out.print("<h3> Registeration Failed !!! </h3>");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/register.html");
		requestDispatcher.include(req, resp);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
