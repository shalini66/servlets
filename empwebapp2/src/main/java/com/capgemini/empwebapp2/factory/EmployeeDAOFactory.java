package com.capgemini.empwebapp2.factory;

import com.capgemini.empwebapp2.dao.EmployeeDAO;
import com.capgemini.empwebapp2.dao.EmployeeDAOImplements;

public class EmployeeDAOFactory {
	
	private EmployeeDAOFactory(){}
	
	public static EmployeeDAO getEmployeeDAO() {
		return new EmployeeDAOImplements();
	}
}
