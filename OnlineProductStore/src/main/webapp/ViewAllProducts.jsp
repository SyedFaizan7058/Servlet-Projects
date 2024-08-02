<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.bean_files.*,java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View All Products</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f8f9fa;
}

.container {
	max-width: 1200px;
	margin: 0 auto;
	padding: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

th, td {
	padding: 10px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

.edit, .delete {
	text-decoration: none;
	padding: 6px 12px;
	border-radius: 5px;
	color: #fff;
	cursor: pointer;
}

.edit {
	background-color: #007bff;
}

.delete {
	background-color: #dc3545;
}

.add-product-btn, .logout-btn {
	display: inline-block;
	padding: 10px 20px;
	border-radius: 5px;
	color: #fff;
	text-decoration: none;
	margin-bottom: 20px;
}

.add-product-btn {
	background-color: #28a745;
}

.logout-btn {
	background-color: #dc3545;
}

.add-product-btn:hover, .logout-btn:hover, .edit:hover, .delete:hover {
	opacity: 0.8;
}

.btn-container {
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Welcome, Admin!</h1>
		<div class="btn-container">
			<a href="AddProduct.html" class="add-product-btn">Add Product</a> <a
				href="Logout" class="logout-btn">Logout</a>
		</div>
		<table>
			<thead>
				<tr>
					<th>Code</th>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				AdminBean ab = (AdminBean) session.getAttribute("abean");
				ArrayList<ProductBean> list = (ArrayList<ProductBean>) session.getAttribute("plist");
				out.println("Page belongs to Admin :" + ab.getFname() + "<br><br>");
				if (list.isEmpty()) {
				%>
				<tr>
					<td colspan="5">No Product is Available...</td>
				</tr>
				<%
				} else {
				%>
				<%
				for (ProductBean pb : list) {
				%>
				<tr>
					<td><%=pb.getCode()%></td>
					<td><%=pb.getName()%></td>
					<td><%=pb.getPrice()%></td>
					<td><%=pb.getQty()%></td>
					<td><a href='edit?pcode=<%=pb.getCode()%>' class='edit'>Edit</a>
						<a href='delete?pcode=<%=pb.getCode()%>' class='delete'>Delete</a>
					</td>
				</tr>
				<%
				}
				%>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
