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

	<h3>Step1: Select an Airliner:</h3>
	<form action="${contextPath}/admin/newFlight-2.htm" method="get">
		<table>
			<tr>
				<td>Airliner:</td>
				<td><select name="airliner" required="required">
						<c:forEach var="airliner" items="${airliners}">
							<option value="${airliner.name}">${airliner.name}</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<input type="submit" value="submit"/>
	</form>
</body>
</html>