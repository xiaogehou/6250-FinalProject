<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy Success</title>
</head>
<body>
	<h1>Add new Flight ${flight.flightNum} Successfully!</h1>
	<a href="${pageContext.request.contextPath}/admin/home">[Back to Home]</a>  
</body>
</html>