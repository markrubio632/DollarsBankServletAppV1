<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%> <!-- tag not needed -->
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
	<form:form method="post" modelAttribute="user">
		<div class="header" align="center" style="padding-top: 5%">
			<h1>Welcome to DollarsBank Banking Registration!</h1>
		</div>
		<div class="container" align="right" id="login-link">
			<label for="login-link">Already a user? Login</label> <a
				href="/login">here</a>
		</div>

		<!-- USERNAME -->
		<div class="form-group">
			<label for="name-text">User Name:</label>
			<form:input path="userName" placeholder="User Name" name="userName"
				id="name-text" required="true" />
		</div>
		<!-- PASSWORD -->
		<div class="form-group">
			<label for="pass-text">Password:</label>
			<form:password path="userPass" placeholder="Password" name="userPass"
				id="pass-text" required="true" />

		</div>
		<!-- ADDRESS -->
		<div class="form-group">
			<label for="address-text">Address:</label>
			<form:input path="userAddress" placeholder="Address"
				name="userAddress" id="address-text" required="true" />
		</div>
		<!-- CONTACT NUMBER -->
		<div class="form-group">
			<label for="contact-text">Contact Number:</label>
			<form:input path="userContact" placeholder="Format: xxxxxxxxxx"
				name="userContact" id="contact-text" required="true" />
		</div>
		<!-- BALANCE -->
		<div class="form-group">
			<label for="balance-text">Initial Balance:</label> <input
				type="number" placeholder="00.00" name="userBalance"
				id="balance-text" required />
		</div>
		<!-- ACCOUNT NAME -->
		<div class="form-group">
			<label for="account-text">Account Name:</label>
			<form:input path="userAcc" placeholder="Account Name" name="userAcc"
				id="account-text" required="true" />

		</div>
		<div align="center">
			<form:button type="submit" class="btn btn-lg btn-primary">Register</form:button>
			<c:if test="${errorMessage != null}">
				<div class="alert alert-danger" style="width: 40%">${errorMessage}</div>
			</c:if>
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