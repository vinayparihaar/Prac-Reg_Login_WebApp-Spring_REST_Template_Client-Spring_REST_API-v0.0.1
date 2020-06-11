<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.Date"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>

<body>

	<p> <spring:message code="label.currentLocalDateTime" /><b><%=new Date()%></b></p>
	<p> <spring:message code="label.currentServerDateTime" /><b>${serverTime}</b></p>
	<%-- <h1>${headerMessage}</h1> --%>
	<h1> <b> <spring:message code="label.headerMessage" /> </b> </h1>
	<h3>Home Page</h3>
	<h2>Welcome!!</h2>
	
	<table>

		<tr>
			<td></td>
			<td>
				<a href="login"> 
					<b>Login</b>
				</a>
			</td>
			<td></td>
		</tr>

		<tr>
			<td></td>
			<td>
				<a href="register"> 
					<b>Register</b>
				</a>
			</td>
			<td></td>
		</tr>

	</table>
	
</body>
</html>
