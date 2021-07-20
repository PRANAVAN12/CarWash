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

<style>
.pending {
	width: 78px;
	border-radius: 4px;
	height: 28px;
	margin-left: 2px;
	font-size: 18px;
	color: white;
	padding: 5px;
	background: orange;
	font-size: 18px;
	color: white;
	text-align: center;
}

.Approved {
	width: 85px;
	border-radius: 4px;
	height: 28px;
	top: -2px;
	font-size: 18px;
	color: white;
	padding: 5px;
	background: green;
	padding: 5px;
	text-align: center;
	font-size: 18px;
}

.Cancelled {
	width: 85px;
	border-radius: 4px;
	height: 25px;
	margin: 5px;
	top: -2px;
	font-size: 18px;
	color: white;
	text-align: center;
	background: red;
}

.Cancel {
	width: 75px;
	border-radius: 4px;
	height: 25px;
	margin: 5px;
	top: -2px;
	font-size: 18px;
	text-align: center;
	color: white;
	background: red;
}

.appp {
	width: 85px;
	border-radius: 4px;
	height: 25px;
	margin: 5px;
	top: -2px;
	font-size: 18px;
	text-align: center;
	color: white;
	background: green;
}

.edit {
	width: 75px;
	border-radius: 4px;
	height: 25px;
	margin: 5px;
	top: -2px;
	font-size: 18px;
	text-align: center;
	color: white;
	background: burlywood;
}
</style>
<body>
	<%@include file="header.jsp"%>
	<div class="container" style="margin-left: 20%; padding-top: 5%">
		<h3 class="text-center">List of Bookings</h3>
		<hr>
		<div class="container text-left">

			<a href="<%=request.getContextPath()%>/new-booking"
				class="btn btn-success">Add Booking</a>
		</div>


		<br>
		<table class="table table-bordered">
			<thead>
				<tr>

					<th>User</th>
					<th>Email</th>
					<th>Package</th>

					<th>Booking Date</th>
					<th>Status</th>
					<th>Total Amount</th>

					<th>Actions</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="user" items="${listRoomBooking}">

					<tr>
						<td><c:out value="${user.user}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.carpack}" /></td>

						<td><c:out value="${user.bookingdate}" /></td>
						<td><c:if test="${user.status == 'Pending'}">
								<div class="pending">
									<c:out value="${user.status}" />
								</div>
							</c:if> <c:if test="${user.status == 'Approved'}">
								<div class="Approved">
									<c:out value="${user.status}" />
								</div>
							</c:if> <c:if test="${user.status == 'Cancelled'}">
								<div class="Cancelled">
									<c:out value="${user.status}" />
								</div>
							</c:if></td>
						<td><c:out value="${user.amount}" /></td>


						<td>

							<div class="edit">
								<a style="color: white"
									href="edit-booking?id=<c:out value='${user.id}' />">Edit</a>
							</div> <c:if test="${user.status != 'Approved'}">
								<div class="appp">

									<a style="color: white"
										href="confirm?id=<c:out value='${user.id}' />">Approve</a>
								</div>
							</c:if> <c:if test="${user.status != 'Cancelled'}">
								<div class="cancel">
									<a style="color: white"
										href="usercancel?id=<c:out value='${user.id}' />">Cancel</a>

								</div>
							</c:if>




						</td>
					</tr>
				</c:forEach>
				<!-- } -->
			</tbody>

		</table>
	</div>
</body>
</html>