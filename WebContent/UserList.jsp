<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<%@include file="header.jsp" %>
		<div class="container" style="margin-left: 20%; padding-top:5%">
			<h3 class="text-center">List of Customers</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newuser" class="btn btn-success">New Customer</a>
			</div>
			
				
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
					
						  <th>Full name</th>
						<th>User Name</th>
						<th>Mobile</th>
						<th>Address</th>
						<th>Mail</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					  	<c:forEach var="user" items="${listUsers}">

				<tr>
					<td><c:out value="${user.fullname}" /></td>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${user.mobile}" /></td>
							<td><c:out value="${user.address}" /></td>
							<td><c:out value="${user.mail}" /></td>

							<td><a href="useredit?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="userdelete?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>