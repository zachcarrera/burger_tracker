<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger Tracker</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script defer src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="w-50 mx-auto mt-3">
		<h1>Burger Tracker</h1>

		<table class="table">
			<thead>
				<tr>
					<th>Burger Name</th>
					<th>Restaurant Name</th>
					<th>Rating (out of 5)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="eachBurger" items="${burgers }">
					<tr>
						<td><c:out value="${eachBurger.name }" /></td>
						<td><c:out value="${eachBurger.restaurantName }" /></td>
						<td><c:out value="${eachBurger.rating }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<h2>Add Burger</h2>
		<form:form action="/burgers/new" method="post" modelAttribute="newBurger">
			<div class="mb-3">
				<form:label path="name" class="form-label">Burger Name</form:label>
				<form:input path="name" type="text" class="form-control" />
				<p class="form-text text-danger"><form:errors path="name"/></p>
			</div>
			<div class="mb-3">
				<form:label path="restaurantName" class="form-label">Restaurant Name</form:label>
				<form:input path="restaurantName" type="text" class="form-control" />
				<p class="form-text text-danger"><form:errors path="restaurantName"/></p>
			</div>
			<div class="mb-3">
				<form:label path="rating" class="form-label">Rating</form:label>
				<form:input path="rating" type="number" class="form-control" />
				<p class="form-text text-danger"><form:errors path="rating"/></p>
			</div>
			<div class="mb-3">
				<form:label path="notes" class="form-label">Notes</form:label>
				<form:textarea path="notes" class="form-control" rows="3"></form:textarea>
				<p class="form-text text-danger"><form:errors path="notes"/></p>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>

		</form:form>
	</div>
</body>
</html>