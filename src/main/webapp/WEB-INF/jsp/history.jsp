<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DOLLARSBANK Transaction History</title>
</head>
<body>
	<header>
		<div align="left">
			<a href="/login">Login Out</a>
		</div>
	</header>
	<form:form>
		<div align="center">

			<table border="1">
				<caption>
					<h2>My Transactions</h2>
				</caption>
				<tr>
					<th>Transaction</th>
				</tr>
				<!-- separated each insert point into the history list as 1 item -->
				<!-- so when we choose to print an item, it prints 1 single transaction -->
				<c:forEach var="item" items="${history}">
					<tr>
						<td><c:out value="${item}" /></td>
					</tr>
				</c:forEach>
			</table>

		</div>

	</form:form>

</body>
</html>