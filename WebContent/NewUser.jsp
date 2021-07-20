<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
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
		<div class="container" style="margin-left: 34%; padding-top:5%" width="60px">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="usrupdate" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insertuser" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit user details
            		</c:if>
						<c:if test="${user == null}">
            			Add New user
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label> Full Name</label> <input type="text"
						value="<c:out value='${user.fullname}' />" class="form-control"
						name="fullname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> UserName</label> <input type="text"
						value="<c:out value='${user.username}' />" class="form-control"
						name="username">
				</fieldset>

				<fieldset class="form-group">
					<label> Mobile</label> <input type="number" pattern=".{10}"
						value="<c:out value='${user.mobile}' />" class="form-control"
						name="mobile">
				</fieldset>
				<fieldset class="form-group">
					<label> Address</label> <input type="text"
						value="<c:out value='${user.address}' />" class="form-control"
						name="address" required="required">
				</fieldset>

					<fieldset class="form-group">
					<label> Mail</label> <input type="text"
						value="<c:out value='${user.mail}' />" class="form-control"
						name=mail required="required">
				</fieldset>


				<fieldset class="form-group">
					<label> Password</label> <input type="text"
						value="<c:out value='${user.password}' />" class="form-control"
						name="password" required="required">
				</fieldset>
			


				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>