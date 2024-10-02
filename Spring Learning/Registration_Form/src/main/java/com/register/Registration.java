package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/register")
public class Registration extends HttpServlet{
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
	String name = req.getParameter("name");
	String pass = req.getParameter("pass");
	String email = req.getParameter("email");
	String gender = req.getParameter("gender");
	String course = req.getParameter("course");
	
//	Cookie cookie1 = new Cookie("name", name);
//	Cookie cookie2 = new Cookie("pass", pass);
//	Cookie cookie3 = new Cookie("email", email);
//	Cookie cookie4 = new Cookie("gender", gender);
//	Cookie cookie5 = new Cookie("course", course);
//	
//	resp.addCookie(cookie1);
//	resp.addCookie(cookie2);
//	resp.addCookie(cookie3);
//	resp.addCookie(cookie4);
//	resp.addCookie(cookie5);
	
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	
	//cookies management code
//	out.println("<h3><a href='detail'>View Details</a></h3>");
	
	//url rewriting code
//	out.println("<h3><a href='detail?name=" + name + "&pass=" + pass + "&email=" + email + "&gender=" + gender + "&course=" + course + "'>View Details</a></h3>");
	
	//hidden form code
	out.println("<form action='detail'>"
		+ "<input type='hidden' name='name' value='"+name+"'>"
		+ "<input type='hidden' name='pass' value='"+pass+"'>"
		+ "<input type='hidden' name='email' value='"+email+"'>"
		+ "<input type='hidden' name='gender' value='"+gender+"'>"
		+ "<input type='hidden' name='course' value='"+course+"'>"
		+ "<button>Submit</button>"
		+ "</form>");
    }

}
