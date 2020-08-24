<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>DollarsBank Main Menu</title>
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
	<form:form modelAttribute="user">
		<div class="header" align="center" style="padding-top: 5%">
			<h1>Thank you for choosing DollarsBank</h1>
			<h2>Please choose an option below</h2>
		</div>
		<div align="center">
			<table border="1" class="table"
				style="text-align: center; width: 25%">
				<thead>
					<tr>
						<th>Options</th>
					</tr>
				</thead>
				<tr>
					<td><a class="btn" href="/deposit">Deposit</a></td>
				</tr>
				<tr>
					<td><a class="btn" href="/withdraw">Withdraw</a></td>
				</tr>
				<tr>
					<td><a class="btn" href="/fundTransfer">Transfer</a></td>
				</tr>
				<tr>
					<td><a class="btn" href="/history">View Transactions
							History</a></td>
				</tr>
				<tr>
					<td><a class="btn" href="/myAccount">My Account Details</a></td>
				</tr>
			</table>
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