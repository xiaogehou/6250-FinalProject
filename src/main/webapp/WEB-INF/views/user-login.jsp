<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body onload='document.f.j_username.focus();'>
	<h3>Login Page</h3>

	<c:if test="${not empty error}">
		<div class="errorblock">
			Login error, try again<br /> cause :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<form name='f' action="${pageContext.request.contextPath}/j_spring_security_check"	method='POST'>

		<table>
			<tr>
				<td>Username:</td>
				<td><input type='text' name='j_username'>
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' />
				</td>
			</tr>
			<tr>
				<td colspan='2'>
				    <input name="submit" type="submit" value="Login" />
				    <input name="reset" type="reset" value="Reset" />
				</td>
			</tr>
			
		</table>

	</form>
</body>
</html>