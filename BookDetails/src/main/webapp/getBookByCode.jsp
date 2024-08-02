<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.test.BookBean,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book By Code</title>
<style type="text/css">
body {
	background-image: url("library2.jpg");
	background-size: 100% 100vh;
	background-repeat: no-repeat;
	color: white;
}

table {
	margin: 210px auto;
	font-size: 30px;
	border: 2px solid white;
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

	<table border="">
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Author</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<%
		Iterator<BookBean> it = list.iterator();
		if (it.hasNext()) {
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