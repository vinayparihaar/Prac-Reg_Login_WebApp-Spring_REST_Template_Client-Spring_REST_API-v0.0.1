<%@page import="java.util.Date"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
</head>

<body>

	<p> <spring:message code="label.currentLocalDateTime" /><b><%=new Date()%></b></p>
	<p> <spring:message code="label.currentServerDateTime" /><b>${serverTime}</b></p>
	<%-- <h1>${headerMessage}</h1> --%>
	<h1> <b> <spring:message code="label.headerMessage" /> </b> </h1>
	<a href="logout"><b>Logout</b></a>
	<br>			
	<h3>Login Success Page</h3>
	<br>
	<h3>Welcome, user logged in with :  ${sessionScope.email}</h3>
	<br>
	<h2>Congratulation!!! Mr./Ms. ${user.lastName}, you have successfully logged in</h2>
	<h2>Mr./Ms. ${user.lastName}, your credentials are Email : ${email} , Password :  ${password}</h2>
		
	<table>
		<tr>
			<td><spring:message code="label.email" /></td>
			<td>${login.email}</td>
		</tr>

		<tr>
			<td><spring:message code="label.password" /></td>
			<td>${login.password}</td>
		</tr>
		
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
			<td>${user.password}</td>
			<!-- <td>********** (Please Login to see your password.)</td> -->
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
		
		<!-- <tr>
			<td></td>
			<td>
				<label for="">To logout of your account.</label>
					<a href="logout">
						<b>Click Here</b>
					</a>
			</td>
           <td></td>	
		</tr> -->
	
	</table>	

</body>
</html>