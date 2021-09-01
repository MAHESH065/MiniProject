<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<title>Contact Info Page</title>
</head>
<body>

	<h2>Contact Information</h2>
	<h4>
		<font color="blue">${success}</font> <font color="red">${error}</font>
	</h4>

	<form:form action="saveContact?contactId=${contact.contactId}"
		method="POST" modelAttribute="contact">

		<div class="mb-2 row">
			<label for="cname" class="col-sm-1 col-form-label">Name</label>
			<div class="col-sm-3">
				<form:input path="contactName" id="cname" placeholder="Enter Contact Name" class="form-control"  />
			</div>
		</div>

		<div class="mb-2 row">
			<label for="cemail" class="col-sm-1 col-form-label">Email</label>
			<div class="col-sm-3">
				<form:input path="contactEmail" id="cemail" placeholder="Enter Contact Email" class="form-control" />
			</div>
		</div>

		<div class="mb-2 row">
			<label for="cnumber" class="col-sm-1 col-form-label">Ph.No</label>
			<div class="col-sm-3">
				<form:input path="contactNumber" id="cnumber" placeholder="Enter Contact Number" class="form-control" />
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>

	</form:form>

	<br>
	<a href="viewContact">View All Contacts</a>

</body>
</html>