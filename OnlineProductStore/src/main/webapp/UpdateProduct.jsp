<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateProduct</title>
    <style>
        .card-content {
            font-size: 20px;
            color: black;
            text-align: center;
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
            <%@include file="ViewAllProducts.jsp" %>
        </div>
    </div>

</body>
</html>