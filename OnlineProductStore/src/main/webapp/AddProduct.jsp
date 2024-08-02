<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.bean_files.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminPage</title>
</head>
<body>

	<%
	try {
		AdminBean ab = (AdminBean) session.getAttribute("abean");
		String msg = (String) request.getAttribute("msg");
		out.println("Page belongs to Admin : " + ab.getFname() + "<br><br>");
		out.println(msg);
	} catch (Exception e) {
		request.setAttribute("msg", "First You Have to Login...<b>");
        request.getRequestDispatcher("Message.jsp").forward(request, response);
	}
	%>
	<a href="AddProduct.html">AddProduct</a>
	<br>
	<br>
	<a href="view1">ViewAllProducts</a>
	<br>
	<br>
	<a href="Logout">Logout</a>


</body>
</html>