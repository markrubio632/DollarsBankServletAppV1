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
	<form:form method="post">
		
		<table border="1">
  			<tr>
    			<td>Amount:</td>
   				<td>
      				<input type = "number" name = "amount" size = "30" step='0.01' value='0.00' placeholder='0.00' required>
    			</td>
  			</tr>
  			<tr>
    			<td>Current Balance:</td>
   				<td>
      				<td>${user.userBalance}</td>
    			</td>
  			</tr>
	</table>
	<p><input type = "submit" value = "submit"></p>
		
	</form:form>

</body>
</html>