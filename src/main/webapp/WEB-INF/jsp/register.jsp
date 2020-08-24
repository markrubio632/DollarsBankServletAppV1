<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<style>
.form-group {
	margin: 1%;
	text-align: center;
}
</style>
<style>
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	text-align: center;
	background-color: black;
	color: white;
}
</style>

<title>DollarsBank Registration</title>
</head>
<body>

	<header>
		<div align="right">
			Already a user? <a href="/login" class="btn-basic"
				style="padding-right: 1%;">Login</a>
		</div>
	</header>
	<form:form method="post" modelAttribute="user">
		<div class="header" align="center" style="padding-top: 5%">
			<h1>Welcome to DollarsBank Banking Registration!</h1>
		</div>
		<div class="form-group">
			User Name:
			<form:input path="userName" placeholder="User Name" name="userName" />
		</div>
		<div class="form-group">
			Password:
			<form:input path="userPass" placeholder="Password" name="userPass" />

		</div>
		<div class="form-group">
			Address:
			<form:input path="userAddress" placeholder="Address"
				name="userAddress" />

		</div>
		<div class="form-group">
			Contact Number:
			<form:input path="userContact" placeholder="Phone number"
				name="userContact" />

		</div>

		<div class="form-group">
			Initial Balance:
			<form:input path="userBalance" placeholder="Initial Balance"
				name="userBalance" />

		</div>
		<div class="form-group">
			Account Name:
			<form:input path="userAcc" placeholder="Account Name" name="userAcc" />

		</div>
		<div align="center">
			<form:button type="submit" class="btn btn-lg btn-primary">Register</form:button>
		</div>


	</form:form>
	<div class="footer">

		<p>Thank you for using DOLLARSBANK Inc. Please thank our owner and
			proprietor for the wonderful opportunity DollarsBank has to serve our
			community!</p>
		<a href="https://github.com/markrubio632" target="_blank"><img
			src="Professional_Pic.jpg" style="width: 5%"></a>
	</div>

</body>
</html>