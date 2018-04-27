<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Flight Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->

<link rel="stylesheet"
	href="../resources/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="../resources/css/bootstrap.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<div class="container">
		<h3>Add a New Flight</h3>
		<div class="well">Step2: set new flight values:</div>

		<form class="form-horizontal"
			action="${contextPath}/admin/createFlight.htm" method="post">
			<input name="airliner" type="hidden" value="${airliner.name}" />

			<div class="form-group">
				<label>Airplane:</label> <select class="form-control"
					name="airplane" required="required">
					<c:forEach var="a" items="${airplanes}">
						<option value="${a.modelNumber}">${a.modelNumber}</option>
					</c:forEach>
				</select>
			</div>
			<br>
			<div class="form-group">
				<label>From:</label> <input name="from" type="text"
					required="required" />
			</div>
			<br>
			<div class="form-group">
				<label>To:</label> <input name="to" type="text" required="required" />

			</div>
			<br>
			<div class="form-group">
				<label>Departure Time:</label>
				<div id="datetimepicker" class="input-append date">
					<input data-format="yyyy/MM/dd hh:mm:ss" name="departing"
						type="text" required="required"></input> <span class="add-on">
						<i data-time-icon="icon-time" data-date-icon="icon-calendar">
					</i>
					</span>
				</div>
			</div>
			<br>
			<div class="form-group">
				<label>Arriving Time:</label>
				<div id="datetimepicker1" class="input-append date">
					<input data-format="yyyy/MM/dd hh:mm:ss" name="arriving"
						type="text" required="required"></input> <span class="add-on">
						<i data-time-icon="icon-time" data-date-icon="icon-calendar">
					</i>
					</span>
				</div>
			</div>
			<br>
			<div class="form-group">
				<input class="btn btn-default" type="submit" value="Create" />
			</div>

		</form>
	</div>


	<script src="../resources/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#datetimepicker').datetimepicker({
				language : 'pt-BR'
			});
		});
		$(function() {
			$('#datetimepicker1').datetimepicker({
				language : 'pt-BR'
			});
		});
	</script>
</body>

</html>