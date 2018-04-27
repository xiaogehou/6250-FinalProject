<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Buy Success</title>
</head>
<body>
	<div class="well">
		<center>
			<h1>History Orders</h1>
		</center>
	</div>
	<div class="container">
		<h4>User: ${user.username}</h4>
		<a href="${pageContext.request.contextPath}">[Back to Search]</a>


		<c:forEach items="${user.customers}" var="customer">
			<c:set var="flights" value="${customer.flights}" />
			<c:if test="${flights!=null&&fn:length(flights)!=0}">
				<p class="bg-warning" style="padding: 10px">Passenger:
					${customer.name}</p>
				<table class="table table-striped" border="1">
					<tr>
						<td><h4>Flight Number</h4></td>
						<td><h4>Departure</h4></td>
						<td><h4>Destination</h4></td>
						<td><h4>Airplane Model</h4></td>
						<td><h4>Airliner</h4></td>
						<td><h4>Departure Time</h4></td>
						<td><h4>Arriving Time</h4></td>
					</tr>
					<c:forEach var="flight" items="${flights}">
						<tr>
							<td>${flight.flightNum}</td>
							<td>${flight.departure}</td>
							<td>${flight.destination}</td>
							<td>${flight.airplane.modelNumber}</td>
							<td>${flight.airplane.airliner.name}</td>
							<td>${flight.departureTime}</td>
							<td>${flight.arrivingTime}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</c:forEach>
	</div>
</body>
</html>