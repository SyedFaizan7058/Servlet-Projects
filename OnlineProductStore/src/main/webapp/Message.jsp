<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Message File</title>
    <style>
        .card {
            margin: 20px auto;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .card-body {
            padding: 20px;
        }

        .card-content {
            font-size: 16px;
            color: white;
        }
    </style>
</head>
<body>

    <%
    String msg = (String) request.getAttribute("msg");
    %>

    <div class="card">
        <div class="card-body">
            <p class="card-content"><%= msg %></p>
            <%@include file="index.html" %>
        </div>
    </div>

</body>
</html>
