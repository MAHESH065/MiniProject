<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Contacts Page</title>
</head>
<body>
	<div align="center">
		
		<h2>View Contact List</h2>
		<a href="contact">Add Contact</a>
		<table border="1">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone_No</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contact}" var="con">
					<tr>
						<td>${con.contactId}</td>
						<td>${con.contactName}</td>
						<td>${con.contactEmail}</td>
						<td>${con.contactNumber}</td>
						<td>
							<a href="#">Update</a> &nbsp;
							<a href="#">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>