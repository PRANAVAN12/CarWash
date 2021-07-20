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

	<%@include file="header.jsp"%>
	<div class="container" style="margin-left: 34%; padding-top: 5%"
		>
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update-package" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert-package" method="post" >
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit Package 
            		</c:if>
						<c:if test="${user == null}">
            			Add New Package
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label> Name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

	<fieldset class="form-group">
					<label> Description</label> <input type="text"
						value="<c:out value='${user.description}' />" class="form-control"
						name="description" required="required">
				</fieldset>
			
				
				<fieldset class="form-group">
					<label> Charge </label> <input type="number" pattern=".{10}"
						value="<c:out value='${user.cost}' />" class="form-control"
						name="cost" required="required">
				</fieldset>

			
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>