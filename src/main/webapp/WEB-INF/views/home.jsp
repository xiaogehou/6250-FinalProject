<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
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

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WebTools</a>
			</div>

			<div class="collapse navbar-collapse" id="myNavbar">
				<c:choose>
					<c:when test="${empty user}">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="${contextPath}/login.htm"><span
									class="glyphicon glyphicon-log-in"></span>Login</a></li>
							<li><a href="${contextPath}/register.htm"><span
									class="glyphicon glyphicon-user"></span>Sign Up</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul class="nav navbar-nav">
							<li><a href="#">Welcome, ${user.username}</a></li>
							<li><a href="${contextPath}/user/tickets.htm">My History
									Orders</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="${contextPath}/logout.htm">Logout</a></li>
						</ul>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</nav>

	<div class="container">
		<form class="form-horizontal" action="${contextPath}/search.htm"
			method="get">
			<div class="form-group">
				<label class="control-label col-sm-2" for="from">Flying
					From:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="from" id="from"
						placeholder="Origin" required="required">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="to">Flying To:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="to" id="to"
						placeholder="Destination" required="required">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Departing:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="date" id="datepicker"
						placeholder="Date" required="required">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Search</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
