<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ProductNotAvailable</title>
<style type="text/css">

        .card-content {
            font-size: 25px;
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
            <%@include file="BuyProduct.jsp" %>
        </div>
    </div>
</body>
</html>