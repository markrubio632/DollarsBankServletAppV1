<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DOLLARSBANK Login Page</title>
</head>
<body>
	<form:form method="post" modelAttribute="user">
	
		<div class="container">
			User Name: <form:input path="userName" placeholder="User Name" name="userName"/><br>
			Password: <form:input path="userPass" placeholder="Password" name="userPass"/>
		</div>
		<form:button type="submit">Log In</form:button>

	</form:form>

</body>
</html>