<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<title>Contact Info Page</title>
</head>
<body>

	<h2>Contact Information</h2>
	<h4>
		<font color="blue">${success}</font> <font color="red">${error}</font>
	</h4>

	<form:form action="saveContact?contactId=${contact.contactId}" method="POST" modelAttribute="contact">

		<div class="mb-2 row">
			<label for="cname" class="col-sm-1 col-form-label">Name</label>
			<div class="col-sm-3">
				<form:input path="contactName" id="cname" class="form-control" />
			</div>
		</div>

		<div class="mb-2 row">
			<label for="cemail" class="col-sm-1 col-form-label">Email</label>
			<div class="col-sm-3">
				<form:input path="contactEmail" id="cemail" class="form-control" />
			</div>
		</div>

		<div class="mb-2 row">
			<label for="cnumber" class="col-sm-1 col-form-label">Ph.No</label>
			<div class="col-sm-3">
				<form:input path="contactNumber" id="cnumber" class="form-control" />
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>

	</form:form>

	<br>
	<a href="viewContact">View All Contacts</a>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
		integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js"
		integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/"
		crossorigin="anonymous"></script>

</body>
</html>