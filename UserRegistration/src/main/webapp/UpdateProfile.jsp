<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
<link rel="stylesheet" href="UpdateProfile.css">
</head>
<body>

	<div class="container">
		<h1>Update Profile</h1>
		<div class="message">
			<%
			String fName = (String) request.getAttribute("fName");
			out.println("Page Belongs to User: " + fName + "<br><br>");
			out.println("Profile Updated Successfully...<br>");
			%>
		</div>
		<div class="profile-links">
			<a href="view">View Profile</a> <a href="edit">Edit Profile</a> <a
				href="logout">Logout</a>
		</div>
	</div>

</body>
</html>
