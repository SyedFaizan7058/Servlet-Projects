<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.test.BookBean,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>
<style type="text/css">
body {
	background-image: url("library2.jpg");
	background-size: 100% 100vh;
	background-repeat: no-repeat;
	font-family: Arial, sans-serif;
	color: white;
}

table {
	width: 70%;
	border-collapse: collapse;
	margin: 200px auto;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 10px;
	border-bottom: 1px solid #ddd;
	text-align: left;
}

th {
	background-color: gray;
}
</style>
</head>
<body>

	<%
	ArrayList<BookBean> list = (ArrayList<BookBean>) request.getAttribute("list");

	if (list.size() == 0) {
		out.println("Invalid Book Code");
	} else {
	%>

	<table border="1">
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Author</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<%
		Iterator<BookBean> it = list.iterator();
		while (it.hasNext()) {
			BookBean b = it.next();
		%>
		<tr>
			<td><%=b.getCode()%></td>
			<td><%=b.getName()%></td>
			<td><%=b.getAuthor()%></td>
			<td><%=b.getPrice()%></td>
			<td><%=b.getQty()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>


</body>
</html>