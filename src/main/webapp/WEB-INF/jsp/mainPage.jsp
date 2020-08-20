<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="user">
		<div align="center">
			<table border="1">
				<thead>
					<tr>
						<th>Options</th>
					</tr>
				</thead>
				<tr>
					<td><a class="button" href="/deposit">Deposit</a></td>
				</tr>
				<tr>
					<td><a class="button" href="/withdraw">Withdraw</a></td>
				</tr>
				<tr>
					<td><a class="button" href="/fundTransfer">Transfer</a></td>
				</tr>
				<tr>
					<td><a class="button" href="/history">View Transactions
							History</a></td>
				</tr>
				<tr>
					<td><a class="button" href="/myAccount">My Account Details</a></td>
				</tr>
			</table>
		</div>
		</form:form>
</body>
</html>