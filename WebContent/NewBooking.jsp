<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

</head>
<style>

.card{

width:600px;

}

.btn-success {
    color: #fff;
    width: 562px;
    background-color: #28a745;
    border-color: #28a745;
}


</style>
<body>
<%@include file="header.jsp" %>
		<div class="container" style="margin-left: 34%; padding-top:5%">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update-booking" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert-booking" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit Booking
            		</c:if>
						<c:if test="${user == null}">
            			Add New Booking
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label> User</label> <input type="text"
						value="<c:out value='${user.user}' />" class="form-control"
						name="user" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label> Package </label> <input type="text"
						value="<c:out value='${user.carpack}' />" class="form-control"
						name="carpack">
				</fieldset>
			

				<fieldset class="form-group">
					<label> Booking Date</label> <input type="date"
						value="<c:out value='${user.bookingdate}' />" class="form-control"
						name="bookingdate">
				</fieldset>
<fieldset class="form-group">

	<p>
					Select Destination : <select name="status"  style=" width:560px;height: 40px;"
						value="<c:out value='${user.status}' />">
						<option>Pending</option>
						<option>Approved</option>
							<option>Cancelled</option>
						</select>
					
				</fieldset>
				<fieldset class="form-group">
					<label> Total Amount</label> <input type="number" pattern=".{10}"
						value="<c:out value='${user.amount}' />" class="form-control"
						name="amount">
				</fieldset>
				
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>