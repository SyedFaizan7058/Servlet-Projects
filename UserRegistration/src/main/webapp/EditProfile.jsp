<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
<link rel="stylesheet" href="EditProfile.css">
</head>
<body>

	<div class="container">
		<h1>Edit Profile</h1>
		<%
		try {
		String fName = (String) request.getAttribute("fName");
			UserBean ub = (UserBean) application.getAttribute("ubean");
			out.println("Page Belongs to User: " + fName + "<br><br>");

		} catch (Exception e) {
			out.println("You Have Logged Out Already...<br>");
		}
		%>
		<form action="update" method="post">
			<input type="text" name="addr" value=""
				placeholder="Enter new Address"><br> <br> <input
				type="email" name="mid" value="" placeholder="Enter new MailId"><br>
			<br> <input type="number" name="phno" value=""
				placeholder="Enter new Phone Number"><br> <br> <input
				type="submit" value="Update Profile">
		</form>
	</div>

</body>
</html>
