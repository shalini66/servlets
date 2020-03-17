package com.capgemini.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.naming.Context;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.webapp.dto.User;

public class MyFirstServlet extends HttpServlet {
	
	
	
	public MyFirstServlet() {
		System.out.println("Object of MyFirstServlet Created");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init method..");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy method");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
				throws ServletException, IOException {
		
		
		ServletConfig config =getServletConfig();
		String empName = config.getInitParameter("name");
		
		ServletContext context = getServletContext();
		String company = context.getInitParameter("company");
		
		User user = new User();
		user.setId(1);
		user.setName("Shalini");
		user.setEmail("shalini@gmail.com");
		context.setAttribute("user", user);
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		Date date = new Date();
		out.println("<h1 style='color:red'>");
		
		out.println(date);
		out.println("</h1>");
		
		out.println("<h1>");
		out.println(name);
		out.println("</h1>");
		
		out.println("<h1>");
		out.println(age);
		out.println("</h1>");
		
		out.println("<h1>Empname:");
		out.println(empName);
		out.println("</h1>");
		
		out.println("<h1>Company:");
		out.println(company);
		out.println("</h1>");
		
		
		out.println("</body>");
		out.println("</html>");
	}
}
