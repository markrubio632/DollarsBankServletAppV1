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
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="user">
		<div class="container" align="center">

			<!-- may need to be ${user.userBalance} - check the name of what is put in model -->
			Your current balance is: ${userBalance}<br> 
			Please Enter an Amount to Withdraw:
			<fmt:formatNumber value="amount" type="currency" />
			<%-- <form:input path="amount" placeholder="amount" name="amount" /> --%>

			<!-- I believe this will make it so that the 
			amount cannot be empty to display the submit button -->
			<c:choose>
				<c:when test="${empty amount}">
				Please enter an amount.
				</c:when>
				<c:otherwise>
					<form:button type="submit">Withdraw</form:button>
				</c:otherwise>
			</c:choose>
		</div>
	</form:form>

</body>
</html>