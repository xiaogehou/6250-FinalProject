<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Add Flight Form</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<div class="container">
		<h3>Add a New Flight</h3>

		<div class="well">
			<h4>Step1: Select an Airliner:</h4>
		</div>
		<form action="${contextPath}/admin/newFlight-2.htm" method="get">
			<div class="form-group">
				<label>Airliner:</label> <select class="form-control"
					name="airliner" required="required">
					<c:forEach var="airliner" items="${airliners}">
						<option value="${airliner.name}">${airliner.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<input class="btn btn-default" type="submit" value="submit" />
			</div>
		</form>
	</div>
</body>
</html>