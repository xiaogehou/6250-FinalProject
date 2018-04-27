<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Result</title>
</head>
<body>

	<div class="well">
		<center><h2>Here are the search results</h2></center>
	</div>
	<div class="container">
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
			<a href="${contextPath}">[Back to Search]</a>
		<table border="1" class="table table-striped">
			<tr>
				<td><h4>Flight Number</h4></td>
				<td><h4>Departure</h4></td>
				<td><h4>Destination</h4></td>
				<td><h4>Airplane Model</h4></td>
				<td><h4>Airliner</h4></td>
				<td><h4>Departure Time</h4></td>
				<td><h4>Arriving Time</h4></td>
				<td><h4>Available Seats</h4></td>
			</tr>
			<c:forEach items="${results}" var="flight">
				<tr>
					<td>${flight.flightNum}</td>
					<td>${flight.departure}</td>
					<td>${flight.destination}</td>
					<td>${flight.airplane.modelNumber}</td>
					<td>${flight.airplane.airliner.name}</td>
					<td>${flight.departureTime}</td>
					<td>${flight.arrivingTime}</td>
					<td>${flight.availSeatsNum}<a
						href="${contextPath}/user/buyTicket.htm?flightNum=${flight.flightNum}">[Buy
							Ticket]</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>