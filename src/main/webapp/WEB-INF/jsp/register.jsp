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
<div class="container">
			User Name: <form:input path="userName" placeholder="User Name" name="userName"/><br>
			Password: <form:input path="userPass" placeholder="Password" name="userPass"/>
			Address: <form:input path="userAddress" placeholder="Address" name="userAddress"/>
			Contact Number: <form:input path="userContact" placeholder="Phone number" name="userContact"/>
			Initial Balance: <form:input path="userBalance" placeholder="Initial Balance" name="userBalance"/>
			Account Name: <form:input path="userAcc" placeholder="Account Name" name="userAcc"/>
		</div>
		<form:button type="submit">Register</form:button>

</form:form>

</body>
</html>