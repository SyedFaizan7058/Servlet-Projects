<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP_Demo</title>
</head>
<body>

	<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	out.println("Id :" + id);
	out.println("<br>Name :" + name);
	%>
	<br>
	<%@include file="index.html"%>

</body>
</html>