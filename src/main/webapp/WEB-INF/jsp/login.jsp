<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>DollarsBank Login</title>
<style>
.form-group {
	margin: 2%;
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
</head>
<body>
	<form:form method="post" modelAttribute="user">
		<div class="header" align="center" style="padding-top: 5%">
			<h1>Please Login to DollarsBank</h1>
		</div>

		<div class="container" align="right">
			New User? Register <a href="/register">Here</a>
		</div>

		<!-- USERNAME -->
		<div class="form-group" align="center">
			<label for="name-text">User Name:</label>
			<form:input path="userName" id="name-text" placeholder="User Name"
				name="userName" required="true" />
		</div>
		<!-- USERNAME -->
		<div class="form-group" align="center">
			<label for="pass-text">Password:</label>
			<form:password path="userPass" placeholder="Password" name="userPass"
				required="true" id="pass-text" />
		</div>
		<!-- LOGIN BUTTON -->
		<div class="form-group" align="center">
			<form:button class="btn btn-lg btn-primary" type="submit">Log In</form:button>
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