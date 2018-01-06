<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:choose> 
	<c:when test="${ customer.id == null }">
		<title>Add Customer</title>
	</c:when>
	<c:otherwise>
		<title>Update Customer</title>
	</c:otherwise>
</c:choose>
<link type="text/css" 
	rel="stylesheet" 
	href="${ pageContext.request.contextPath }/resources/css/style.css" />
<link type="text/css" 
	rel="stylesheet" 
	href="${ pageContext.request.contextPath }/resources/css/add-customer-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
	<c:choose> 
	<c:when test="${ customer.id == null }">
		<h3>Add Customer</h3>
	</c:when>
	<c:otherwise>
		<h3>Update Customer</h3>
	</c:otherwise>
	</c:choose>

		<form:form action="addCustomer" modelAttribute="customer" method="post">
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName"/></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName"/></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email"/></td>
					</tr>
					<tr>
						<td><label>Role:</label></td>
						<td><form:input path="role"/></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>   
				</tbody>
			</table>
		</form:form>
		<div style="clear; both;">
		
			<p>
				<a href="${ pageContext.request.contextPath }/customer/list">Back To List</a>
			</p>
		</div>
	</div>
</body>
</html>