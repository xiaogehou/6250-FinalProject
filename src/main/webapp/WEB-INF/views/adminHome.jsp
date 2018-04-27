<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<h2>Welcome, admin</h2>
	<a href="${contextPath}/logout.htm">[Logout]</a>
	<a href="${contextPath}/admin/newFlight.htm">[Create New Flight]</a>
	<div>
		<form action="${contextPath}/admin/search.htm" method="post">
			Flying From: <input type="text" name="from" /> Flying To: <input
				type="text" name="to" /></br> <input type="submit" value="Search" />
		</form>

		<c:if test="${flights!=null&&fn:length(flights)!=0}">

			<table border="1">
				<tr>
					<td><h4>Flight Number</h4></td>
					<td><h4>Departure</h4></td>
					<td><h4>Destination</h4></td>
					<td><h4>Airplane Model</h4></td>
					<td><h4>Airliner</h4></td>
					<td><h4>Departure Time</h4></td>
					<td><h4>Arriving Time</h4></td>
					<td><h4>Method</h4></td>
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
					href="${contextPath}/admin/manageFlight?flightNum=${flight.flightNum}">[Update]</a></td></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

</body>
</html>
