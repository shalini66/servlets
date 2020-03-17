package com.capgemini.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
	out.println("<html><body><h1>");
	out.println("Executing Get Method");
	out.println("</h1></body></html>");
	

//	ServletContext context = getServletContext();
//	String company = context.getInitParameter("company");
//	
//	out.println("<h1>Company:");
//	out.println(company);
//	out.println("</h1>");
//	
	
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("name");
	String email = req.getParameter("email");
	String gender = req.getParameter("gender");
	String password = req.getParameter("password");	
	
	PrintWriter out = resp.getWriter();
	out.println("<html><body><h1>");
	out.println("Executing Post Method");
	
	out.println("</h1>");
	out.println("<h1>Name:");
	out.println(name);
	out.println("</h1>");
	
	out.println("<h1>Email:");
	out.println(email);
	out.println("</h1>");
	
	out.println("<h1>Gender:");
	out.println(gender);
	out.println("</h1>");
	
	out.println("<h1>Password:");
	out.println(password);
	out.println("</h1>");
	
	
	out.println("</body></html>");
	
	}
}
