<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.bean_files.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<link rel="stylesheet" href="CheckEmail.css">
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background: linear-gradient(90deg, #0a0a0a, #3a4454);
	margin: 0;
	padding: 0;
}

.container {
	width: 300px;
	margin: 200px auto;
	padding: 15px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background: linear-gradient(45deg, #0a0a0a, #3a4454);
	border: 2px solid white;
}

.container h2{
	color: white;
	text-align: center;
}

input[type="password"] {
	width: calc(100% - 20px);
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

input[type="submit"] {
	width: 100%;
	padding: 10px;
	border: none;
	border-radius: 5px;
	background-color: #007bff;
	color: #fff;
	cursor: pointer;
	margin-bottom: 15px;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
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