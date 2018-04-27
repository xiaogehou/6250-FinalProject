<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add User Form</title>
<script>
	function checkname() {
		var xmlHttp;
		try // Firefox, Opera 8.0+, Safari
		{
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try // Internet Explorer
			{
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("Your browser does not support AJAX!");
					return false;
				}
			}
		}

		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				var str = xmlHttp.responseText;
				if (str == "true") {
					document.getElementById("msg").innerHTML = "<span style='color:#00cc00'>Valid Username</span>";
				} else {
					document.getElementById("msg").innerHTML = "<span style='color:#cc0000'>Invalid Username</span>";
				}
			}
		}

		var name = document.getElementById("UserName").value;

		xmlHttp.open("GET", "../check.htm?username=" + name, true);
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlHttp.send();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<a href="${contextPath}">Go Back</a>
	<br />

	<h2>Register a New User</h2>

	<form action="${contextPath}/register" method="post">

		<table>

			<tr>
				<td>User Name:</td>
				<td><input type="text" size="30" id="UserName" name="username"
					required="required" />
					<div id="msg"></div></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" size="30" name="password"
					required="required" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Register User" /></td>
			</tr>
		</table>

	</form>
</body>
</html>