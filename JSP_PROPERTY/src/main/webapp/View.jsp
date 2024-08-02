<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.test.RegisterBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="ob" class="com.test.RegisterBean" scope="session"/>
	<%out.println("You Have Enterd below details...<br>"); %>
	<jsp:getProperty property="name" name="ob" /><br>
	<jsp:getProperty property="pass" name="ob" />

</body>
</html>