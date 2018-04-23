<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</head>
<body>
	<c:set var="userId" value="${sessionScope.user}" />
	<c:set var="user" value="${sessionScope.u}" />
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:choose>
		<c:when test="${empty user}">
			<div>
				<a href="${contextPath}/login.htm">[Login]</a> 
				<a href="${contextPath}/register.htm">[Create An Account]</a>
			</div>
		</c:when>
		<c:otherwise>
			<h2>Welcome, ${user.name}</h2>
			<a href="${contextPath}/user/logout.htm">[Logout]</a>
			<a href="${contextPath}/user/tickets.htm">[View History Orders]</a>
		</c:otherwise>
	</c:choose>
	<div>
		<form action="${contextPath}/search.htm" method="get">
			Flying From: <input type="text" name="from" required="required"/></br> Flying To: <input
				type="text" name="to" required="required"/></br> Departing: <input type="text"
				id="datepicker" name="date" required="required"/></br> <input type="submit" value="Search" />
		</form>
	</div>

</body>
</html>
