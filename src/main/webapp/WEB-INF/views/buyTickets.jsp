<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<title>Buy Tickets</title>
</head>
<body>
	<div class="well">
		<center>
			<h2>Buy Tickets</h2>
		</center>
	</div>
	<div class="container">
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<a href="${contextPath}">[Back to Search]</a>
		<c:set var="customers" value="${user.customers}" />
		<br>
		<div class="panel-group">
			<div class="panel panel-info">
				<div class="panel-heading">Choose Passengers:</div>
				<div class="panel-body">
					<c:if test="${customers!=null&&fn:length(customers)!=0}">
						<form action="${contextPath}/user/buyTicket.htm" method="post">
							<div class="checkbox">
								<c:forEach var="customer" items="${customers}">
									<label class="checkbox-inline"><input type="checkbox"
										name="customer" value="${customer.id}" />${customer.name}</label>
								</c:forEach>
							</div>
							<input class="btn btn-default" type="submit" value="Buy Tickets" />
						</form>
					</c:if>
				</div>
			</div>
		</div>
		<div class="panel-group">
			<div class="panel panel-warning">
				<div class="panel-heading">Add a Passenger:</div>
				<div class="panel-body">
				<form action="${contextPath}/user/addCustomer.htm" method="post">
					New Customer Name: <input type="text" name="newName" /> <input
						class="btn btn-default" type="submit" value="Add New Customer" />
				</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>