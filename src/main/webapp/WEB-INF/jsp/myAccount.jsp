<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>DOLLARSBANK My Account</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
	<form:form method="post" modelAttribute="user">
		<div class="header" align="center" style="padding-top: 5%">
			<h2>My Account Details</h2>
		</div>
		<div align="center" style="padding: 1%">
			<table border="1" class="table"
				style="text-align: center; width: 25%">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Password</th>
					<th>Address</th>
					<th>Contact</th>
					<th>Balance</th>
					<th>Account Name</th>
				</tr>
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.userName}" /></td>
					<td><c:out value="${user.userPass}" /></td>
					<td><c:out value="${user.userAddress}" /></td>
					<td><c:out value="${user.userContact}" /></td>
					<td><fmt:formatNumber value="${user.userBalance}"
							type="currency" /></td>
					<td><c:out value="${user.userAcc}" /></td>
				</tr>
			</table>
			<a href="/mainPage" class="btn btn-lg btn-dark">Main Page</a>
		</div>
	</form:form>
	<div class="footer">

		<p>Thank you for using DOLLARSBANK Inc. Please thank our owner and
			proprietor for the wonderful opportunity DollarsBank has to serve our
			community!</p>
		<img src="Professional_Pic.jpg" style="width: 5%">
	</div>

</body>
</html>