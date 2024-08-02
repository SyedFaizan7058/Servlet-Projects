<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.bean_files.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    .container {
        max-width: 800px;
        margin: 50px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
    }

    .container h1 {
        color: #333;
        margin-bottom: 20px;
    }

    .welcome-msg {
        margin-bottom: 20px;
    }

    .profile-links {
        display: flex;
        justify-content: center;
        align-items: center;
        gap: 20px;
    }

    .profile-link {
        text-decoration: none;
        background-color: #007bff;
        color: #fff;
        padding: 10px 20px;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }

    .profile-link:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<div class="container">
    <h1>Login Success</h1>
    <div class="welcome-msg">
        <%
        UserBean ub = (UserBean) session.getAttribute("ubean");
        out.println("Welcome User: " + ub.getfName()+"<br><br>");
        %>
    </div>
    <div class="profile-links">
        <a href="view2" class="profile-link">View All Products</a>
        <a href="Logout" class="profile-link">Logout</a>
    </div>
</div>

</body>
</html>
