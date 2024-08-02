<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.test.StudentBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login File</title>
</head>
<body>

	<%
	StudentBean sb = (StudentBean) application.getAttribute("sbean");
	out.println("Welcome Student : " + sb.getName()+"<br><br>");
	%>

	<a href="update.html"><input type="submit" value="Update"></a>
	<a href="delete.html"><input type="submit" value="Delete"></a>

</body>
</html>