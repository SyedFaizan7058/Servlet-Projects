<%@page import="com.email.RandomNumber"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.bean_files.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f2f2f2;
}

.container {
	max-width: 800px;
	margin: 20px auto;
	padding: 20px;
	border-radius: 10px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	display: flex;
	flex-wrap: wrap;
}

.user-info {
	flex: 1 1 300px;
	margin-right: 20px;
	padding: 20px;
	border-radius: 10px;
	background-color: #f9f9f9;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	margin-bottom: 20px;
}

.user-info a input {
	text-decoration: none;
	font-size: 15px;
	width: 100px;
	color: white;
	background-color: #333;
	cursor: pointer;
}

.order-history {
	flex: 1 1 300px;
	padding: 20px;
	border-radius: 10px;
	background-color: #f9f9f9;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	margin-bottom: 20px;
}

.profile-picture {
	width: 150px;
	height: 150px;
	border-radius: 50%;
	margin-bottom: 20px;
	border: 5px solid #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.user-info strong {
	display: block;
	margin-bottom: 10px;
	font-weight: bold;
	color: #333;
}

.section-heading {
	margin-top: 20px;
	margin-bottom: 10px;
	font-size: 24px;
	color: #333;
}

.order-history-item {
	margin-bottom: 10px;
	padding: 10px;
	border-radius: 5px;
	background-color: #fff;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

.order-history-item strong {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
	color: #333;
}

img:hover {
	transform: translateY(-10px);
}

.user-info a input:active {
	color: black;
	background-color: #ffff;
	cursor: pointer;
	border: none;
}
</style>
</head>
<body>

	<div class="container">
		<%
		try {
			UserBean ub = (UserBean) session.getAttribute("ubean");
		%>

		<div class="profile-conatainer">
			<div class="user-info">
				<h1><%=ub.getuName()%>'s Profile
				</h1>
				<img src="Images/profileImage.jpeg" alt="Profile Picture"
					class="profile-picture"> <strong>User Name:</strong>
				<%=ub.getuName()%><br> <strong>First Name:</strong>
				<%=ub.getfName()%>
				<strong>Last Name:</strong>
				<%=ub.getlName()%>
				<strong>Email:</strong>
				<%=ub.getMid()%>
				<strong>Address:</strong>
				<%=ub.getAddr()%>
				<strong>Phone Number:</strong>
				<%=ub.getPhno()%><br>
				<br> <a href="Logout"><input type="submit" value="Logout"></a>
			</div>
		</div>
		<%
		%>
		<div class="order-history">
			<h2 class="section-heading">Order History</h2>
			<div class="order-history-item">
				<strong>Order ID:</strong><%=RandomNumber.getOrderId()%><br> <strong>Date:</strong><%=LocalDate.now()%><br>
				<strong>Items:</strong><%="abc..."%><br> <strong>Total
					Amount:</strong>
				<%="1200.00"%>
			</div>
		</div>

		<%
		} catch (NullPointerException e) {
		%>
		<%
		request.setAttribute("msg", "First You have to Login...uhdhuif<br>");
		request.getRequestDispatcher("Message.jsp").forward(request, response);
		%>
		<%
		}
		%>
	</div>

</body>
</html>
