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
	<form:form method="post" modelAttribute="user">
		<div align="center">
			<table border="1">
				<caption>
					<h2>My Transactions</h2>
				</caption>
				<!-- <tr>
					<th>Transaction</th>
				</tr> -->
				<c:forEach var="item" items="${history}">
				<tr>
					<td><c:out value="${item.item}"/></td>
				</tr>
				</c:forEach>
			</table>
		</div>

	</form:form>

</body>
</html>