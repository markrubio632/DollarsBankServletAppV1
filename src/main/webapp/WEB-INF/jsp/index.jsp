<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!-- tags obtained from external sources -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- link to the bootstrap CDN, to utilize bootstrap in the page -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<!-- helps keep responsive formatting for mobile devices/ desktop resizing -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>DollarsBank Inc</title>
<!-- style formatting for the footer class -->
<style>
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	text-align: center;
	background-color: black;
	color: white;
}
</style>
</head>
<body>
<!-- FOR MAJORITY OF CLASSES - REFER TO BOOTSTRAP STYLING -->
<!-- https://getbootstrap.com/docs/4.5/getting-started/introduction/ -->
	<form:form modelAttribute="user">
		<div class="header" align="center" style="padding-top: 2%">
			<h1>Welcome to DollarsBank Banking!</h1>
		</div>

		<div align="center" style="padding-top: 1%">
			<img src="dollarsbank.jpg" style="width: 20%">
		</div>

		<div class="text-center" style="padding: 1%">
			<a class="btn btn-primary btn-lg" href="/login">Login</a> <a
				class="btn btn-primary btn-lg" href="/register">register</a>
		</div>

	</form:form>

	<div class="footer">

		<p>Thank you for using DOLLARSBANK Inc. Please thank our owner and
			proprietor for the wonderful opportunity DollarsBank has to serve our
			community!</p>
		<a href="https://github.com/markrubio632" target="_blank"><img
			src="Professional_Pic.jpg" style="width: 5%"></a><!-- the ' target="_blank" ' opens the link in a new browser tab-->
	</div>

</body>
</html>