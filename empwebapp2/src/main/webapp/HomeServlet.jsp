<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="bean" class="com.capgemini.empwebapp2.dto.EmployeeBean" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home page</title>
</head>
<body>
	<a href='./changepassword.html'>Change Password</a>
	<a href='./logout' style='float: right;'>Logout</a>
	<h1>Welcome<%=bean.getName() %></h1>
	<a href='./search'>Search</a>
</body>
</html>