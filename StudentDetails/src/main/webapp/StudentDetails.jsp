<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.test.StudentBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>

	<%
	String name = (String) request.getAttribute("name");
	StudentBean sb = (StudentBean) session.getAttribute("sbean");
	out.println("Your Details Are...<br>");
	out.println(name + "<br>");
	out.println(sb.getAge() + "<br>");
	out.println(sb.getPhno() + "<br>");
	out.println(sb.gethDegree() + "<br>");
	out.println(sb.getYear() + "<br>");
	out.println(sb.getUniversity() + "<br>");
	%>

</body>
</html>