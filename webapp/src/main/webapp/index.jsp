<%@page import="java.util.Date"%>
<jsp:useBean id="user" class="com.capgemini.webapp.dto.User" scope="application"></jsp:useBean>
<%@include file="/index.html" %>

<%@page session="false" %>
<%@page isThreadSafe="false" %>
<%@page errorPage="error.jsp" %>
<%
Date date = new Date();
%>

<%! int count=10;
String name = "shalini";

void print(){
	System.out.println(count);
}
%>
<html>
<body>
<h1 style="color:green"><%=date %></h1>
<h3><%=user.getId() %></h3>
<h3><%=user.getName() %></h3>
<h3><%=user.getEmail() %></h3>
<h3><%=user.getPassword() %></h3>
</body>
</html> 