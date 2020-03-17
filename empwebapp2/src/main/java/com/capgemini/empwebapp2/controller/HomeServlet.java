package com.capgemini.empwebapp2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.empwebapp2.dto.EmployeeBean;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session == null) {
			req.getRequestDispatcher("login.html").forward(req, resp);
		} else {
//			Object obj = session.getAttribute("bean");
//			EmployeeBean bean = (EmployeeBean)obj;
//			
//			PrintWriter out = resp.getWriter();
//			out.println("<html><body>");
//			
//			out.println("<a href='./changepassword.html'>Change Password</a>");
//			out.println("<a href='./logout' style='float: right;'>Logout</a>");
//			
//			out.println("<h1>Welcome");
//			out.println(bean.getName());
//			out.println("</h1>");
//			
//			out.println("<a href='./search'>Search</a>");
//			
//			out.println("</body></html>");
			req.getRequestDispatcher("HomeServlet.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
