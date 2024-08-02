<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
<link rel="stylesheet" href="LoginSuccess.css">
</head>
<body>

	<div class="container">
		<h1>Login Success</h1>
		<div class="welcome-msg">
			<%
			UserBean ub = (UserBean) application.getAttribute("ubean");
			out.println("Welcome User: " + ub.getfName());
			%>
		</div>
		<div class="profile-links">
			<a href="view">View Profile</a> <a href="edit">Edit Profile</a> <a
				href="logout">Logout</a>
		</div>
	</div>

</body>
</html>
