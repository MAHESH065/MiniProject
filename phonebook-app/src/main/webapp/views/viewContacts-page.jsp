<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>View Contacts Page</title>
</head>
<body>
	<div align="center">
		
		<h2>View Contact List</h2>
		<a href="contact"><font size="5px">Add Contact</font></a><br><br>
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone No</th>
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
							<a href="update?id=${con.contactId}">Update</a> &nbsp;
							<a href="delete/${con.contactId}" onclick="if(!(confirm('Are you sure? you want to delete contact record !'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
</body>
</html>