<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DOLLARSBANK Transaction History</title>
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
	<form:form>
		<div class="header" align="center" style="padding-top: 5%">
			<h2>Transaction History</h2>
		</div>
		<div align="center" style="padding: 1%">

			<table border="1" class="table"
				style="text-align: center; width: 25%">
				<tr>
					<th>List of Transactions</th>
				</tr>
				<!-- separated each insert point into the history list as 1 item -->
				<!-- so when we choose to print an item, it prints 1 single transaction -->
				<c:forEach var="item" items="${history}">
					<tr>
						<td><c:out value="${item}" /></td>
					</tr>
				</c:forEach>
			</table>
			<a href="/mainPage" class="btn btn-lg btn-dark">Back</a>
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