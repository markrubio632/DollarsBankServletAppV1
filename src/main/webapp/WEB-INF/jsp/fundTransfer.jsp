<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fund transfer</title>
</head>
<body>
	<header>
		<div align="left">
			<a href="/login">Login Out</a>
		</div>
	</header>
	<form:form method="post">

		<table border="1">
			<tr>
				<td>Who do you want to transfer to?</td>
				<td><input type="text" name="recId" size="30"
					placeholder='recId' required></td>
			</tr>
			<tr>
				<td>Amount to Transfer:</td>
				<td><input type="number" name="amount" size="30" step='0.01'
					value='0.00' placeholder='0.00' required></td>
			</tr>
			<tr>
				<td>Current Balance Available:</td>
				<td>${user.userBalance}</td>
			</tr>
		</table>
		<p>
			<input type="submit" value="submit">
		</p>

	</form:form>

</body>
</html>