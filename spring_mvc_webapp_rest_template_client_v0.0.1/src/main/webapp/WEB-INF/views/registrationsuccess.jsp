<%@page import="java.util.Date"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>

	<p> <spring:message code="label.currentLocalDateTime" /><b><%=new Date()%></b></p>
	<p> <spring:message code="label.currentServerDateTime" /><b>${serverTime}</b></p>
	<%-- <h1>${headerMessage}</h1> --%>
	<h1> <b> <spring:message code="label.headerMessage" /> </b> </h1>
	<a href="index"> <b>Home Page</b> </a>
	<h3>Registration Success Page</h3>
	<h2>Welcome!!! "${user.firstName} ${user.lastName}" you are Successfully registered. </h2>
	<br>
	<table>
		<tr>
			<td><spring:message code="label.firstName" /></td>
			<td>${user.firstName}</td>
		</tr>

		<tr>
			<td><spring:message code="label.lastName" /></td>
			<td>${user.lastName}</td>
		</tr>

		<tr>
			<td><spring:message code="label.email" /></td>
			<td>${user.email}</td>
		</tr>

		<tr>
			<td><spring:message code="label.phone" /></td>
			<td>${user.phone}</td>
		</tr>

		<tr>
			<td><spring:message code="label.password" /></td>
			<%-- <td>${user.password}</td> --%>
			<td>********** (Please Login to see your password.)</td>
		</tr>

		<tr>
			<td><spring:message code="label.lineOne" /></td>
			<td>${user.address.lineOne}</td>
		</tr>

		<tr>
			<td><spring:message code="label.lineTwo" /></td>
			<td>${user.address.lineTwo}</td>
		</tr>

		<tr>
			<td><spring:message code="label.city" /></td>
			<td>${user.address.city}</td>
		</tr>

		<tr>
			<td><spring:message code="label.state" /></td>
			<td>${user.address.state}</td>
		</tr>

		<tr>
			<td><spring:message code="label.zipcode" /></td>
			<td>${user.address.zipcode}</td>
		</tr>

		<tr>
			<td><spring:message code="label.country" /></td>
			<td>${user.address.country}</td>
		</tr>

		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		
		<tr>
			<td></td>
			<td></td>
			<td><label for="">Click here for </label>
					<a href="index">
						<b>Home Page </b>
					</a>
			</td>
           <td></td>
           <td></td>	
		</tr>

	</table>

</body>
</html>