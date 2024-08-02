<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<link rel="stylesheet" href="CheckEmail.css">
</head>
<body>

	<%
    UserBean ub = (UserBean) application.getAttribute("userbean");
	%>
	
	<div class="container">
	<form action="change" method="post">
	<h2>Create new Password</h2>
	<input type="password" name="pass1" placeholder="Enter new Password"><br><br>
	<input type="password" name="pass2" placeholder="Confirm Password"><br><br>
	<input type="submit" value="Change Password">
	</form>
	</div>

</body>
</html>