<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.bean_files.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success JSP Page</title>
<style type="text/css">
body{
    background-image: url("image1.jpg");
	background-size: 100% 100vh;
	background-repeat: no-repeat;
	color: white;
	font-family: sans-serif;
}
.container{
    width: 400px;
    margin: 170px auto;
    text-align: center;
    font-size: 25px;
}

.container a{
    display: inline-block; 
    width: 220px; 
    height: 50px; 
    text-align: center; 
    line-height: 50px; 
    margin: 5px; 
    background-color: white;
    color: black;
    text-decoration: none;
    border-radius: 10px;
}

.container a:hover {
	background-color: #333;
	color:white;
	transition: background-color 0.8s ease;
}
</style>
</head>
<body>

    <div class="container">
	<%
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	out.println("Welcome Admin : " + ab.getUname()+"<br><br>");
	%>

	<a href="AddProduct.html">AddProduct</a><br><br>
	<a href="view1">ViewAllProducts</a><br><br>
	<a href="Logout">Logout</a>
	
	</div>


</body>
</html>