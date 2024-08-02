<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.bean.ProductBean,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Product Details</title>
</head>
<body>

	<%
	ArrayList<ProductBean> list = (ArrayList<ProductBean>) application.getAttribute("list");
	%>
	<table border="1">
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<%
		Iterator<ProductBean> it = list.iterator();
		while (it.hasNext()) {
			ProductBean b = it.next();
		%>
		<tr>
			<td><%=b.getCode()%></td>
			<td><%=b.getName()%></td>
			<td><%=b.getPrice()%></td>
			<td><%=b.getQty()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	out.println("<br>");
	%>

	<%@include file="index.html"%>

</body>
</html>