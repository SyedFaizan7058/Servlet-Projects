<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.test.RegisterBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>

	<jsp:useBean id="ob" class="com.test.RegisterBean" scope="session" />
	<jsp:setProperty property="name" param="name" name="ob" />
	<jsp:setProperty property="pass" param="pass" name="ob" />

	<%
	out.println("Data Loaded And Available in Bean..<br><br>");
	%>
	
	<a href="View.jsp">ViewDetails</a>
	
</body>
</html>