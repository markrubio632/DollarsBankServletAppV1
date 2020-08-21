<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="user">
		<div class="container" align="center">
			<p2>Your current balance is ${user.userBalance}</p2>
			<p2>Please select who you would like to send funds to</p2>
			Receiver Name:
			<form:input path="name" placeholder="Receiver Name" name="name" />
			<br>

			<p2>How much would you like to send?</p2>
			> Amount:
			<form:input path="amount" placeholder="Amount to Send" name="amount" />
		</div>

		<form:button type="submit"></form:button>

	</form:form>

</body>
</html>