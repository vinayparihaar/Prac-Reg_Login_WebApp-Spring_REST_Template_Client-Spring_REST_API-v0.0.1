<%@page import="java.util.Date"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>

<body>

	<p> <spring:message code="label.currentLocalDateTime" /><b><%=new Date()%></b></p>
	<p> <spring:message code="label.currentServerDateTime" /><b>${serverTime}</b></p>
	<%-- <h1>${headerMessage}</h1> --%>
	<h1> <b> <spring:message code="label.headerMessage" /> </b> </h1>
	<a href="index"> <b>Home Page</b> </a>					
	<h3>Login Page</h3>
	
	<table>
	<tr>
	<%-- <td><form:errors path="login.*" cssStyle="color: #ff0000;" /></td> --%>
	<td>${invalidEmailPassword}</td>
	<td>${Error}</td>
	</tr>
	<tr>
	</tr>
	</table>
	
	<form:form modelAttribute="login" action="login" method="post">
		
		<table>

			<tr>
				<td><form:label path="email"><spring:message code="label.email" /></form:label></td>
				<td><form:input type="text" id="email" name="email" path="email" /></td>
				<td><form:errors path="email" cssStyle="color: #ff0000;" /></td>			
			</tr>
				
			<tr>
				<td><form:label path="password"><spring:message code="label.password" /></form:label></td>
				<td><form:input type="password" id="password" name="password" path="password" /></td>
				<td><form:errors path="password" cssStyle="color: #ff0000;" /></td>	
			</tr>		
				
			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>

			<tr>
				<td></td>
				<td><form:button id="login" name="login">Login</form:button></td>
				<td></td>
			</tr>

			<tr>
				<td></td>
				<td>
					<label for="">Not Registered ??</label>
						<a href="register">
							<b>Register Here</b>
						</a>
				</td>
				<td></td>
			</tr>

		</table>

	</form:form>

</body>
</html>