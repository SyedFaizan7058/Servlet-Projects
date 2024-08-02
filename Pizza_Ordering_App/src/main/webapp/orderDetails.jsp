<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Details</title>
</head>
<body>

	<h2>Order Details</h2>
	<table border="1">
		<tr>
			<td><b>Name:</b></td>
			<td><%=request.getAttribute("name")%></td>
		</tr>
		<tr>
			<td><b>Crust:</b></td>
			<td><%=request.getAttribute("crust")%></td>
		</tr>
		<tr>
    <tr>
    <td><b>Toppings:</b></td>
    <td>
        <%
        String str[] = (String[]) request.getAttribute("toppings");
        for (String st : str) {
        %>
        <ul><li><%=st%></li></ul><br>
        <%
        }
        %>
    </td>
</tr>


		<tr>
			<td><b>Appetizer:</b></td>
			<td><%=request.getAttribute("appetizer")%></td>
		</tr>
		<tr>
			<td><b>Address:</b></td>
			<td><%=request.getAttribute("address")%></td>
		</tr>
		<tr>
			<td><b>Credit Card:</b></td>
			<td><%=request.getAttribute("creditCard")%></td>
		</tr>
		<tr>
			<td><b>Credit Card Number:</b></td>
			<td><%=request.getAttribute("creditCardNumber")%></td>
		</tr>
		<tr>
			<td><b>Repeat Credit Card Number:</b></td>
			<td><%=request.getAttribute("repeatCreditCardNumber")%></td>
		</tr>
	</table>

</body>
</html>
