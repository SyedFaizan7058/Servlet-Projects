<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewProfile</title>
<link rel="stylesheet" href="ViewUserProfile.css">
</head>
<body>

	<%
	try {
	%>
	<div class="container">
		<%
		UserBean ub = (UserBean) application.getAttribute("ubean");
		%>
		<h1>View Profile</h1>
		<table>
			<tr>
				<th>User Name</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th>Mail-Id</th>
				<th>Phone Number</th>
			</tr>
			<tr>
				<td><%=ub.getuName()%></td>
				<td><%=ub.getfName()%></td>
				<td><%=ub.getlName()%></td>
				<td><%=ub.getAddr()%></td>
				<td><%=ub.getMid()%></td>
				<td><%=ub.getPhno()%></td>
			</tr>
		</table>
		<div class="profile-links">
			<a href="edit">Edit Profile</a> <a href="logout">Logout</a>
		</div>
	</div>
	<%
	} catch (Exception e) {
	request.setAttribute("msg", "First You Have to Login...<br>");
	request.getRequestDispatcher("Fail.jsp").forward(request, response);
	}
	%>
	}

</body>
</html>
