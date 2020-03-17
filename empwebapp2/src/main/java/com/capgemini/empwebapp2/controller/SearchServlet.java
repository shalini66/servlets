package com.capgemini.empwebapp2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.empwebapp2.dao.EmployeeDAO;
import com.capgemini.empwebapp2.dto.EmployeeBean;
import com.capgemini.empwebapp2.factory.EmployeeDAOFactory;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session == null) {
			req.getRequestDispatcher("login.html").forward(req, resp);
		} else {

			//			PrintWriter out = resp.getWriter();
			//			out.println("<html><body>");
			//
			//			out.println("<a href='./home'>Home</a>");
			//			out.println("<a href='./logout' style='float:right;'>Logout</a>");
			//
			//			out.println("<form action='./search'>");
			//			out.println("Search: <input type='text'name='name'>");
			//			out.println("<input type='submit' value='Search'>");

			String name = req.getParameter("name");
			if(name!= null) {
				EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDAO();
				List<EmployeeBean> beans = dao.search(name);

				req.setAttribute("beans", beans);
				req.setAttribute("name", name);
				//				if(beans != null && !beans.isEmpty()) {
				//					out.println("<table>");
				//					out.println("<tr>");
				//					out.println("<td>Name</td><td>Email</td>");
				//					out.println("</tr>");
				//
				//					for(EmployeeBean bean : beans) {
				//						out.println("<tr>");
				//						out.println("<td>");
				//						out.println(bean.getName());
				//						out.println("</td><td>");
				//						out.println(bean.getEmail());
				//						out.println("</td>");
				//						out.println("</tr>");
				//					}	
				//					out.println("</table>");	
				//				} else {
				//					out.println("<h1>No Data Found for the name" 
				//								+ name +"</h1>");
				//				}
				//			}
				//out.println("</body></html>");
			}
			req.getRequestDispatcher("search.jsp").forward(req, resp);
			}
	}
}

		//}

