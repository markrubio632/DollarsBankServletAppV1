<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- fmt tagline found here: https://www.tutorialspoint.com/how-to-format-number-in-jsp -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit Funds</title>
</head>
<body>
	<header>
		<div align="left">
			<a href="/login">Login Out</a>
		</div>
	</header>
	<form:form method="post">
		<%-- <div class="container" align="center">
		
		<!-- may need to be ${user.userBalance} - check the name of what is put in model -->
		Your current balance is: ${userBalance}

			Please Enter an Amount to Deposit:

			<fmt:formatNumber value="amount" type="currency"/>
			<form:input path="amount" placeholder="amount" name="amount" />

			<!-- I believe this will make it so that the 
			amount cannot be empty to display the submit button -->
			<c:choose>
				<c:when test="${empty amount}">
				Please enter an amount.
				</c:when>
				<c:otherwise>
					<form:button type="submit">Deposit</form:button>
				</c:otherwise>
			</c:choose>
		</div> --%>

		<table border="1">
			<tr>
				<td>Amount:</td>
				<td><input type="number" name="amount" size="30" step='0.01'
					value='0.00' placeholder='0.00' required></td>
			</tr>
			<tr>
				<td>Current Balance:</td>
				<td>
				<td>${user.userBalance}</td>
				</td>
			</tr>
		</table>
		<p>
			<input type="submit" value="submit">
		</p>

	</form:form>

</body>
</html>