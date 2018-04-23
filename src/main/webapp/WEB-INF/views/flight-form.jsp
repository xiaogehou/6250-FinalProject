<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Flight Form</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />


	<h2>Add a New Flight</h2>
	<h3>Step2: set new flight values:</h3>
	<form action="${contextPath}/admin/createFlight.htm" method="post">

		<input name="airliner" type="hidden" value="${airliner.name}" />
		<table>

			<tr>
				<td>Airplane:</td>
				<td><select name="airplane" required="required">
						<c:forEach var="a" items="${airplanes}">
							<option value="${a.modelNumber}">${a.modelNumber}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>From:</td>
				<td><input name="from" type="text" required="required" /></td>
			</tr>

			<tr>
				<td>To:</td>
				<td><input name="to" type="text" required="required" /></td>
			</tr>

			<tr>
				<td>Departure Time:</td>
				<td><input name="departing" type="datetime-local"
					required="required" /></td>
			</tr>

			<tr>
				<td>Arriving Time:</td>
				<td><input name="arriving" type="datetime-local"
					required="required" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Create" /></td>
			</tr>
		</table>

	</form>

</body>
</html>