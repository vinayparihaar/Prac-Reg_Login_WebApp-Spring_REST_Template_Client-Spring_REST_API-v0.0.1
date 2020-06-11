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
<title>Registration Error</title>
</head>

<body>

	<p> <spring:message code="label.currentLocalDateTime" /><b><%=new Date()%></b></p>
	<p> <spring:message code="label.currentServerDateTime" /><b>${serverTime}</b></p>
	<%-- <h1>${headerMessage}</h1> --%>
	<h1> <b> <spring:message code="label.headerMessage" /> </b> </h1>
	<a href="index"> <b>Home Page</b> </a>
	<h3>Registration Error Page</h3>
	<br>
	<h2>Registration Unsuccessful.</h2>
	<h3>User with "${user.email}" already exist in records.Please visit "Login" page to login with your existing credentials or use other email to "Register.</h3>
	
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