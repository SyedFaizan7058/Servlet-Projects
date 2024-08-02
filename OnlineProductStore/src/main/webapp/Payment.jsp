<%@page import="com.bean_files.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Payment page</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 600px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	animation: fadeIn 0.5s ease;
}

@
keyframes fadeIn {from { opacity:0;
	
}

to {
	opacity: 1;
}

}
h1 {
	font-size: 24px;
	color: #333;
	margin-bottom: 20px;
	text-align: center;
}

.card {
	background-color: #f0f0f0;
	border-radius: 10px;
	padding: 20px;
	margin-bottom: 20px;
	transition: transform 0.3s ease;
}

.card:hover {
	transform: translateY(-5px);
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.info {
	margin-bottom: 20px;
}

.info p {
	margin: 5px 0;
}

.total-amount {
	font-size: 18px;
	color: #333;
	margin-bottom: 20px;
	text-align: center;
}

.payment-btn {
	width: 96.5%;
	display: inline-block;
	padding: 10px;
	background-color: #FFA41C;
	color: #fff;
	text-align: center;
	text-decoration: none;
	border-radius: 5px;
	transition: background-color 0.3s ease;
}

.payment-btn:hover {
	background-color: #FF9100;
}

.logout-link {
	display: block;
	margin-top: 20px;
	text-align: center;
	text-decoration: none;
	color: #666;
}

.logout-link:hover {
	color: #FF5722;
}
</style>
</head>
<body>

	<div class="container">
		<h1>Payment Card</h1>

		<div class="card">
			<%
			try {
				UserBean ub = (UserBean) session.getAttribute("ubean");
				ProductBean pb = (ProductBean) session.getAttribute("pl");
				String pqty = (String) this.getServletContext().getAttribute("qty");
				Integer qty = (Integer) (Integer.parseInt(pqty));
			%>
			<div class="info">
				<p>
					Name :
					<%=ub.getuName()%></p>
				<p>
					Email :
					<%=ub.getMid()%></p>
			</div>
			<div class="info">
				<p>
					Product :
					<%=pb.getName()%></p>
				<p>
					Price :
					<%=pb.getPrice()%></p>
				<p>
					Quantity :
					<%=qty%></p>
			</div>
			<p class="total-amount">
				Total Amount :
				<%=pb.getPrice() * qty%></p>
			<%
			} catch (NullPointerException e) {
			out.println("You Have to Login First...<br>");
			}
			%>
		</div>

		<a href="ConformPayment.jsp" class="payment-btn">Payment</a><br>
		<br>
	</div>

</body>
</html>
