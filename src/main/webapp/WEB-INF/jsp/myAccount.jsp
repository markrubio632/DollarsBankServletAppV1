<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DOLLARSBANK My Account</title>
</head>
<body>
	<form:form method="post" modelAttribute="user">
		<div align="center">
			<table border="1">
				<caption>
					<h2>My Account</h2>
				</caption>
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
					<td><c:out value="${user.id}"/></td>
					<td><c:out value="${user.userName}"/></td>
					<td><c:out value="${user.userPass}"/></td>
					<td><c:out value="${user.userAddress}"/></td>
					<td><c:out value="${user.userContact}"/></td>
					<td><c:out value="${user.userBalance}"/></td>
					<td><c:out value="${user.userAcc}"/></td>
				</tr>
			</table>
		</div>
		<div class="container" align="center">
			<form:button>Deposit Funds</form:button>
			<form:button>Withdraw Funds</form:button>
			<form:button>Transfer Funds</form:button>
			<form:button>Transaction History</form:button>
		
		</div>

	</form:form>

</body>
</html>