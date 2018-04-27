<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Edit Flight</title>
</head>
<body>
	<div class="well">
		<center>
			<h2>Manage Flight</h2>
		</center>
	</div>
	<div class="container">
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<a
			href="${contextPath}/admin/delete.htm?flightNum=${flight.flightNum}">[Delete
			This Flight]</a> <a href="${pageContext.request.contextPath}/admin/home">[Back
			to Home]</a>
		<div style="margin: 20px"></div>
		<form class="form-horizontal"
			action="${contextPath}/admin/updateFlight.htm?flightNum=${flight.flightNum}"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2">From:</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="from"
						value="${flight.departure}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">To: </label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="to"
						value="${flight.destination}">
				</div>
			</div>
			<div class="form-group">

				<label class="control-label col-sm-2">Departing: </label>
				<div class="col-sm-8">
					<input class="form-control" type="datetime-local" name="departing"
						value="${flight.departureTime}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Arriving:</label>
				<div class="col-sm-8">
					<input class="form-control" type="datetime-local" name="arriving"
						value="${flight.arrivingTime}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Airliner: </label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="airliner"
						value="${flight.airplane.airliner.name}" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Airplane Model:</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="model"
						value="${flight.airplane.modelNumber}" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-default" name="submit" type="submit"
						value="">Update</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>