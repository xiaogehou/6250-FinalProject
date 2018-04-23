<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Flight</title>
</head>
<body>
	<h2>Manage Flight</h2>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<a href="${contextPath}/admin/delete.htm?flightNum=${flight.flightNum}">[Delete
		This Flight]</a>
	<form
		action="${contextPath}/admin/updateFlight.htm?flightNum=${flight.flightNum}"
		method="post">
		From: <input type="text" name="from" value="${flight.departure}"></br>
		To: <input type="text" name="to" value="${flight.destination}">
		</br> Departing: <input type="datetime-local" name="departing"
			value="${flight.departureTime}"></br> Arriving: <input
			type="datetime-local" name="arriving" value="${flight.arrivingTime}"></br>
		Airliner: <input type="text" name="airliner"
			value="${flight.airplane.airliner.name}" readonly="readonly"></br>
		Airplane Model: <input type="text" name="model"
			value="${flight.airplane.modelNumber}" readonly="readonly">
			
		<input name="submit" type="submit" value="Update">
	</form>
</body>
</html>