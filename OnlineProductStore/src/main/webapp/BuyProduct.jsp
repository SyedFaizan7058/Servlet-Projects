<%@page import="com.bean_files.UserBean"%>
<%@page import="com.bean_files.ProductBean"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Buy Magical Product</title>
<link rel="stylesheet"
	href="node_modules/bootstrap-icons/font/bootstrap-icons.css">
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f6e58d;
}

.container {
	max-width: 800px;
	margin: 30px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 20px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
}

.container h1 {
	color: #6c5ce7;
	font-size: 36px;
	margin-bottom: 20px;
	text-align: center;
}

.product-info {
	border-bottom: 2px dashed #6c5ce7;
	padding-bottom: 20px;
	margin-bottom: 20px;
	color: #6c5ce7;
}

#image img {
	height: 200px;
	margin-left: 280px;
}

.star{color: green;}

.product-info p {
	margin: 10px 0;
}

.buy-form label {
	display: block;
	margin-bottom: 10px;
	color: #6c5ce7;
}

.btn {
	display: flex;
}

.btn a, .btn input[type="submit"] {
	flex: 1;
	width: 48%;
	box-sizing: border-box;
	text-align: center;
	padding: 10px;
}

.cart-btn {
	background-color: #f0932b;
	color: #fff;
	border-radius: 10px;
	text-decoration: none;
	margin-right: 5px;
}

#cart i {
	margin-right: 10px;
}

.buy-form input[type="number"] {
	width: 100%;
	padding: 12px;
	margin-bottom: 20px;
	border: 2px solid #6c5ce7;
	border-radius: 10px;
	box-sizing: border-box;
}

.buy-form input[type="submit"] {
	padding: 12px;
	background-color: #fb641b;
	color: #fff;
	border: none;
	font-size: 14px;
	border-radius: 10px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.buy-form input[type="submit"]:hover {
	opacity: 0.9;
}

.buy-form input[type="submit"]:focus {
	outline: none;
}
</style>
</head>
<body>

	<div class="container">
		<h1>Buy Magical Product</h1>
		<div class="product-info">
			<%
			UserBean ub = null;
			ProductBean pb = null;

			try {
				ub = (UserBean) session.getAttribute("ubean");
				pb = (ProductBean) session.getAttribute("pl");
			%>
			<div id="image">
				<img src="<%=pb.getImageUrl()%>" alt="<%=pb.getName()%>">
			</div>
			<div class="star">
				    <i class="bi bi-star-fill"></i>
					<i class="bi bi-star-fill"></i>
					<i class="bi bi-star-fill"></i>
					<i class="bi bi-star-fill"></i>
					<i class="bi bi-star-half"></i>
			</div>
			<br>
			<%
			out.println("Welcome, mighty adventurer " + ub.getfName() + "!<br><br>");
			out.println("Product Code: " + pb.getCode() + "<br>");
			out.println("Product Name: " + pb.getName() + "<br>");
			out.println("Price: " + pb.getPrice() + "<br>");
			out.println("Available Quantity: " + pb.getQty() + "<br>");
			%>
		</div>
		<div class="buy-form">
			<form action="conform" method="post">
				<label for="qty">Required Quantity:</label> <input type="number"
					name="qty" id="qty" value="1" min="1" required max="<%=pb.getQty()%>">
				<input type="hidden" name="pcode" value="<%=pb.getCode()%>">
				<div class="btn">
					<a href='addToCart?pCode=<%=pb.getCode()%>&pName=<%=pb.getName()%>&price=<%=pb.getPrice()%>&qty=<%=pb.getQty()%>' class='cart-btn' id="cart">
					<i class="bi bi-cart4"></i>ADD TO CART</a> 
					<input type="submit" value="BUY NOW">
				</div>
			</form>
		</div>
		<%
		} catch (NullPointerException e) {
		out.println("You Have to Login First...lfgnjld df<br>");
		}
		%>
	</div>

</body>
</html>
