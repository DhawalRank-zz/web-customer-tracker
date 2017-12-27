<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Customers</title>
<link type="text/css" 
	rel="stylesheet" 
	href="${ pageContext.request.contextPath }/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			
			<input type="button" class="add-button" value="Add Customer" onclick="window.location.href='addCustomerForm'; return false;">
			
			<table>
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Role</th>
						<th>Action</th>
					</tr>
				</thead> 
				<tbody>
					<c:forEach var="aCustomer" items="${ customers }">
						<c:url var="updateLink" value="/customer/updateCustomerForm">
							<c:param name="customerId" value="${ aCustomer.id }" />
						</c:url>
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${ aCustomer.id }" />
						</c:url>
						<tr>
							<td>${ aCustomer.firstName }</td>
							<td>${ aCustomer.lastName }</td>
							<td>${ aCustomer.email }</td>
							<td>${ aCustomer.role }</td>
							<td><a href="${ updateLink }">Update</a> | <a onclick="if(!confirm('Are you sure you want to delete this customer?')) return false" href="${ deleteLink }">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody> 
			</table>
		</div>
	</div>
</body>
</html>