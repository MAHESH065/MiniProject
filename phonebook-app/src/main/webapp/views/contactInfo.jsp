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
	<div align="center">
		<h1>Contact Information</h1>

		<h3>
			<font color="blue">${success}</font> <font color="red">${error}</font>
		</h3>
		<div>
			<form:form action="saveContact" method="POST"
				modelAttribute="contact">
				<table>
					<tr>
						<td><label for="cname">Name</label></td>
						<td><form:input path="contactName" id="cname" /></td>
					</tr>
					<tr>
						<td><label for="cemail">Email</label></td>
						<td><form:input path="contactEmail" id="cemail" /></td>
					</tr>
					<tr>
						<td><label for="cnumber">Ph.No</label></td>
						<td><form:input path="contactNumber" id="cnumber" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Submit"></td>
					</tr>
				</table>


			</form:form>

			<br> <a href="viewContact">View All Contacts</a>
		</div>
	</div>

</body>
</html>