<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- fmt tagline found here: https://www.tutorialspoint.com/how-to-format-number-in-jsp -->

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
<title>Deposit Funds</title>

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
	<header>
		<div align="right">
			<a href="/login" class="btn-basic" style="padding-right: 1%;">Log
				Out</a>
		</div>
	</header>
	<form:form method="post">
		<div class="header" align="center" style="padding-top: 5%">
			<h2>Please enter an amount to deposit</h2>
		</div>
		<div align="center" style="padding: 1%">
			<table border="1" class="table"
				style="text-align: center; width: 25%">
				<tr>
					<td>Deposit Amount:</td>
					<td><input type="number" name="amount" size="30" step='0.01'
						value='0.00' placeholder='0.00' required></td>
				</tr>
				<tr>
					<td>Current Balance:</td>
					<td><fmt:formatNumber value="${user.userBalance}"
							type="currency" /></td>
				</tr>
			</table>
			<a href="/mainPage" class="btn btn-lg btn-dark">Back</a> <input
				type="submit" value="submit" class="btn btn-lg btn-primary">

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