<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.bean_files.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewAllProducts</title>
<link rel="stylesheet"
	href="node_modules/bootstrap-icons/font/bootstrap-icons.css">
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f9f9f9;
}

nav {
	display: flex;
	justify-content: space-around;
	align-items: center;
	height: 80px;
	background-color: #2874f0;
}

nav ul {
	display: flex;
}

nav ul li {
	list-style: none;
	margin: 0 15px;
	cursor: pointer;
}

ul li a {
	text-decoration: none;
	color: white;
}

ul i{font-size: 20px;}

ul li a:hover {
	color: rgb(153, 153, 226);
	font-size: 1.04rem;
}

.name {
	color: white;
	font-size: 1.5rem;
	width: 300px;
}

#frontImage{width: 100%; margin-top: 30px; }

/*#select-product{outline: none;background-color: #2874f0;border: none;color:white;}

#select-product option{border: none;}*/
.container {
	display: flex;
	gap: 20px;
	flex-wrap: wrap;
	justify-content: space-around;
	margin: 30px auto;
	padding: 0 20px;
	/*margin: 20px auto;
	padding: 0 20px;
	display: flex;
	flex-wrap: wrap;
	justify-content: space-around;
	gap: 20px;*/
}

.product-card {
	width: 230px;
    border-radius: 8px;
    box-shadow: 0px 2px 8px 0px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    background-color: #fff;
    transition: transform 0.3s ease;
    margin-bottom: 20px;
    box-sizing: border-box;
    display: flex;
    flex-direction: column; 
    align-items: center; 
    padding: 20px;
}

.product-card:hover {
	transform: translateY(-10px);
}

#heart{margin-left: 180px; cursor: pointer;}

.product-card img {
	width: 100%;
	aspect-ratio:3/2;
	object-fit:contain;
	border-bottom: 1px solid #f0f0f0;
}

.product-info {
	padding: 15px;
    text-align: center;
    margin-top: auto;
}

.product-info h4 {
	color: #333;
	font-size: 16px;
}

.product-info .star i{color:green;}

.product-info p {
	margin: 0;
	margin-top:8px;
	color: #555;
	font-size: 14px;
}

/*.product-actions {
	padding: 10px;
    text-align: center;
}

.buy-btn {
	text-decoration: none;
    background-color: #fb641b;
    color: #fff;
    padding: 8px 6px;
    border-radius: 3px;
    transition: background-color 0.3s ease;
    font-size: 14px;
    margin-bottom: 20px;
}

#cart{background: #ff9f00;}
.buy-btn:hover {
	background-color: #f35627;
}*/

footer {
	background-color: #2874f0;
	color: #fff;
	text-align: center;
	padding: 10px 0;
	width: 100%;
}
</style>
</head>
<body>

	<header>
		<nav>
			<marquee class="name" direction="left">Welcome to Our
				Product Store</marquee>
			<div>
				<!-- <select id="select-product">
			<option>View Mobiles</option>
			<option>View Laptops</option>
			</select>-->
				<ul>
					<li><a href="About.jsp">About</a></li>
					<li><a href="ViewProfile">View Profile</a></li>
					<li><a href="#">Contact</a></li>
					<li><a href="viewCart"><i class="bi bi-cart3"></i></a></li>
				</ul>
			</div>
		</nav>
	</header>

	<img id="frontImage" alt="Front Image" src="Images/FrontImage2.png">

	<div class="container">
		<%
		try {
			UserBean ab = (UserBean) session.getAttribute("ubean");
			ArrayList<ProductBean> list = (ArrayList<ProductBean>) session.getAttribute("plist");
			/* out.println("page belongs to User : " + ab.getfName() + "<br><br>");*/

			if (list.isEmpty()) {
				out.println("No Product is Available...<br>");
			} else {
				for (ProductBean pb : list) {
		%>
		<div class="product-card">
		    <i id="heart" class="bi bi-heart"></i>
			<a href='buy?pcode=<%=pb.getCode()%>'><img src="<%=pb.getImageUrl()%>" alt="<%=pb.getName()%>"></a>
			<div class="product-info">
			        
				<h4><%=pb.getName()%></h4>
				<div class="star">
				    <i class="bi bi-star-fill"></i>
					<i class="bi bi-star-fill"></i>
					<i class="bi bi-star-fill"></i>
					<i class="bi bi-star-fill"></i>
					<i class="bi bi-star-half"></i>
			    </div>
				<p>
					Price:
					<%=pb.getPrice()%></p>
				<p>
					Quantity:
					<%=pb.getQty()%></p>
			</div>
		</div>
		<%
		}
		}
		} catch (NullPointerException e) {
		request.setAttribute("msg", "First You Have to Login...<br>");
		request.getRequestDispatcher("Message.jsp").forward(request, response);
		}
		%>
	</div>
	
	<footer>
		<p>&copy; 2024 E-Commerce. All Rights Reserved.</p>
	</footer>

</body>
</html>
