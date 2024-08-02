<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Fail</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<link rel="stylesheet" href="loginfail.css">
</head>
<body>

	<div class="main"></div>
	<div class="container">
		<div class="login-box">
			<div id="message">
				<%
				String msg = (String) request.getAttribute("msg");
				out.println(msg);
				%>
			</div>
			<h2>Login</h2>
			<form action="log" method="post">
				<div class="user-box">
					<input class="invalid invalidPassword" type="text" name="uName"
						required> <label>User Name</label>
				</div>
				<div class="user-box">
					<input class="invalid invalidPassword" type="password" name="pWord"
						id="password" required> <label>Password</label> <span
						class="password-toggle-icon"><i class="fas fa-eye"></i></span>
					<div class="forgotPassword">
						<p>
							<a href="forgot.html"> Forgot Password </a>
						</p>
					</div>
				</div>
				<div class="submitBtnDiv">
					<input type="submit" value="Submit" class="submit">
				</div>
				<div class="newAccount">
					<p>
						Don't have Account? <a href="register.html" class="newAccountSign">Sign
							in</a>
					</p>
				</div>

			</form>
		</div>
	</div>
	<script src="login_script.js"></script>

</body>
</html>