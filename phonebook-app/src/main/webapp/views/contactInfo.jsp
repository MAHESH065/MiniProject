<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Info Page</title>
</head>
<body>

	<h1>Contact Information</h1>
	
	<h3>
		<font color="blue">${success}</font>	
		<font color="red">${error}</font> 	
	</h3>
	<div>
		<form:form action="saveContact" method="POST" modelAttribute="contact">

			<label for="cname">Name</label>
			<form:input path="contactName" id="cname" />
			<br>
			<br>

			<label for="cemail">Email</label>
			<form:input path="contactEmail" id="cemail" />
			<br>
			<br>

			<label for="cnumber">Ph.No</label>
			<form:input path="contactNumber" id="cnumber" />
			<br>
			<br>

			<input type="submit" value="Submit">

		</form:form>

		<br><br> 
		<a href="view">View All Contacts</a>
	</div>

</body>
</html>