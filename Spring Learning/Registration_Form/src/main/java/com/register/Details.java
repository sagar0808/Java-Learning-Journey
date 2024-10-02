package com.register;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
@WebServlet("/detail")
public class Details extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	// Retrieve cookies from the request
//	Cookie[] cookies = req.getCookies();
	
//	String name = "", pass = "", email = "", gender = "", course = "";

	// Extract data from cookies
//	if (cookies != null) {
//	    for (Cookie cookie : cookies) {
//		switch (cookie.getName()) {
//		case "name":
//		    name = cookie.getValue();
//		    break;
//		case "pass":
//		    pass = cookie.getValue();
//		    break;
//		case "email":
//		    email = cookie.getValue();
//		    break;
//		case "gender":
//		    gender = cookie.getValue();
//		    break;
//		case "course":
//		    course = cookie.getValue();
//		    break;
//		}
//	    }
//	}
	
	String name = req.getParameter("name");
	String pass = req.getParameter("pass");
	String email = req.getParameter("email");
	String gender = req.getParameter("gender");
	String course = req.getParameter("course");

	// Set response content type
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();

	// Display user details
	out.println("<h1>User Details</h1>");
	out.println("<p>Name: " + name + "</p>");
	out.println("<p>Password: " + pass + "</p>");
	out.println("<p>Email: " + email + "</p>");
	out.println("<p>Gender: " + gender + "</p>");
	out.println("<p>Course: " + course + "</p>");
    }
}
