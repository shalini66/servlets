package com.capgemini.empwebapp2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.empwebapp2.dao.EmployeeDAO;
import com.capgemini.empwebapp2.dto.EmployeeBean;
import com.capgemini.empwebapp2.factory.EmployeeDAOFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDAO();
		EmployeeBean bean = dao.auth(email, password);
		
		if(bean==null) {
			req.getRequestDispatcher("login.html").forward(req, resp);
		} else {
			HttpSession session = req.getSession(true);
			session.setAttribute("bean", bean);
			req.getRequestDispatcher("home").forward(req, resp);
		}
	}
}
