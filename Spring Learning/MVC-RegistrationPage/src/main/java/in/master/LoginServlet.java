package in.master;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.master.dbconnection.DatabaseConnecter;
import in.master.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	PrintWriter out = resp.getWriter();
	resp.setContentType("text/html");
	String email = req.getParameter("email");
	String pass = req.getParameter("pass");
	try {
	    Connection connection = DatabaseConnecter.connect();
	    
	    String query = "SELECT * FROM studentdata WHERE Email = ? AND password = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setString(1, email);
	    preparedStatement.setString(2, pass);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    
	    if(resultSet.next()) {
		User user = new User();
		
		user.setEmail(resultSet.getString("Email"));
		user.setName(resultSet.getString("name"));
		
		HttpSession session = req.getSession();
		session.setAttribute("sessionKey", user);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("profile.jsp");
		requestDispatcher.forward(req, resp);
		
	    }else {
		out.println("<h3> Invalid Credentials </h3>");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
		requestDispatcher.include(req, resp);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }
}
