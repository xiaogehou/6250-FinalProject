<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buy Tickets</title>
</head>
<body>
	<h2>Buy Tickets</h2>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="customers" value="${sessionScope.user.customers}" />
	<h3>Choose Passengers:</h3>
	<c:if test="${customers!=null&&fn:length(customers)!=0}">
		<form action="${contextPath}/user/buyTicket.htm" method="post">

			<c:forEach var="customer" items="${customers}">
				<input type="checkbox" name="customer" value="${customer.id}" />${customer.name}</br>
			</c:forEach>
			
			<input type="submit" value="Buy Tickets"/>
		</form>
	</c:if>

	<h3>Add a Passenger:</h3>
	<form action="${contextPath}/user/addCustomer.htm" method="post">
		New Customer Name:<input type="text" name="newName" /> <input
			type="submit" value="Add New Customer" />
	</form>
</body>
</html>