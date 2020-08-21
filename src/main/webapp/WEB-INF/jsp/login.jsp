<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DOLLARSBANK Login Page</title>
</head>
<body>
	<header>
		<div align="left">
		<a href="/login">Login Here</a>
		</div>
	</header>
	<form:form method="post" modelAttribute="user">

		<div class="container" align="center">
			User Name:
			<form:input path="userName" placeholder="User Name" name="userName" />
			<br> Password:
			<form:input path="userPass" placeholder="Password" name="userPass" />
			<br><form:button type="submit">Log In</form:button>
		</div>
		

	</form:form>

</body>
</html>