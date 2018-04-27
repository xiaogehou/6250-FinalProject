<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Home</title>
</head>
<body>
	<div class="well">
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<center>
			<h2>Welcome, admin</h2>
		</center>
	</div>
	<div class="container">
		<a href="${contextPath}/logout.htm">[Logout]</a> <a
			href="${contextPath}/admin/newFlight.htm">[Create New Flight]</a>
		<div>
			<form class="form-inline" action="${contextPath}/admin/search.htm"
				method="post">
				<div class="form-group">
					<label>Flying From: </label> <input type="text" name="from"
						class="form-control" />
				</div>
				<div class="form-group">
					<label>Flying To: </label> <input class="form-control" type="text"
						name="to" />
				</div>

				<div class="form-group">
					<input class="btn btn-default" type="submit" value="Search" />
				</div>
			</form>

			<c:if test="${flights!=null&&fn:length(flights)!=0}">

				<table border="1" class="table table-striped">
					<tr>
						<td><h5>Flight Number</h5></td>
						<td><h5>Departure</h5></td>
						<td><h5>Destination</h5></td>
						<td><h5>Airplane Model</h5></td>
						<td><h5>Airliner</h5></td>
						<td><h5>Departure Time</h5></td>
						<td><h5>Arriving Time</h5></td>
						<td><h5>Update</h5></td>
					</tr>
					<c:forEach items="${flights}" var="flight">

						<tr>
							<td>${flight.flightNum}</td>
							<td>${flight.departure}</td>
							<td>${flight.destination}</td>
							<td>${flight.airplane.modelNumber}</td>
							<td>${flight.airplane.airliner.name}</td>
							<td>${flight.departureTime}</td>
							<td>${flight.arrivingTime}</td>
							<td><a
								href="${contextPath}/admin/manageFlight?flightNum=${flight.flightNum}">[Update]</a></td>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>
