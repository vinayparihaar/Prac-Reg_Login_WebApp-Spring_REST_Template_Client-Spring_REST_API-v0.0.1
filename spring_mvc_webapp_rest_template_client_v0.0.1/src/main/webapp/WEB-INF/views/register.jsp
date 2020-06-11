<%@page import="java.util.Date"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<p> <spring:message code="label.currentLocalDateTime" /><b><%=new Date()%></b></p>
	<p> <spring:message code="label.currentServerDateTime" /><b>${serverTime}</b></p>
	<%-- <h1>${headerMessage}</h1> --%>
	<h1> <b> <spring:message code="label.headerMessage" /> </b> </h1>
	<a href="index"> <b>Home Page</b> </a>
	<h3>Registration Page</h3>
	
	<table>
	<tr>
	<%-- <td><form:errors path="user.*" cssStyle="color: #ff0000;" /></td> --%>
	<%-- <td><form:errors path="address.*" cssStyle="color: #ff0000;" /></td> --%>
	</tr>
	<tr>
	</tr>
	</table>

	<form:form method="post" modelAttribute="user" action="register">
	
	<table>
	
	<tr>
	<td><form:label path="firstName"><spring:message code="label.firstName" /></form:label></td>
	<td><form:input type="text" id="firstName" name="firstName" path="firstName" /></td>
	<td><form:errors path="firstName" cssStyle="color: #ff0000;" /></td>
	<td></td>
	</tr>
	
	<tr>
	<td><form:label path="lastName"><spring:message code="label.lastName" /></form:label></td>
	<td><form:input type="text" id="lastName" name="lastName" path="lastName" /></td>
	<td><form:errors path="lastName" cssStyle="color: #ff0000;" /></td>
	<td></td>
	</tr>
	
	<tr>
	<td><form:label path="email"><spring:message code="label.email" /></form:label></td>
	<td><form:input type="text" id="email" name="email" path="email" /></td>
	<td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
	<td></td>
	</tr>
	
	<tr>
	<td><form:label path="phone"><spring:message code="label.phone" /></form:label></td>
	<td><form:input type="text" id="phone" name="phone" path="phone" /></td>
	<td><form:errors path="phone" cssStyle="color: #ff0000;" /></td>
	<td></td>
	</tr>
	
	<tr>
	
	<td><form:label path="password"><spring:message code="label.password" /></form:label></td>
	<td><form:input type="password" id="password" name="password" path="password" /></td>
	<td><form:errors path="password" cssStyle="color: #ff0000;" /></td>
	<td></td>
	</tr>
	
	<%-- <tr>
	
	<td><form:label path="address.lineOne"><spring:message code="label.lineOne" /></form:label></td>
	<td><form:input type="text" id="address.lineOne" name="address.lineOne" path="address.lineOne" /></td>
	<td><form:errors path="address.lineOne" cssStyle="color: #ff0000;" /></td>
	<td></td>
	</tr> --%>
	
	<tr>
	
	<td><form:label path="address.lineOne"><spring:message code="label.lineOne" /></form:label></td>
	<td><form:input type="text" id="address.lineOne" name="address.lineOne" path="address.lineOne" /></td>
	<td><form:errors path="address.lineOne" cssStyle="color: #ff0000;" /></td>
	<td></td>
	</tr>
	
	<tr>
	
	<td><form:label path="address.lineTwo"><spring:message code="label.lineTwo" /></form:label></td>
	<td><form:input type="text" id="address.lineTwo" name="address.lineTwo" path="address.lineTwo" /></td>
	<td><form:errors path="address.lineTwo" cssStyle="color: #ff0000;" /></td>
	<td></td>
	</tr>
	
	<tr>
	<td><form:label path="address.city"><spring:message code="label.city" /></form:label></td>
	<td><form:input type="text" id="address.city" name="address.city" path="address.city" /></td>
	<td><form:errors path="address.city" cssStyle="color: #ff0000;" /></td>
	<td></td>
	</tr>
	
	<tr>
	<td><form:label path="address.state"><spring:message code="label.state" /></form:label></td>
	<td><form:input type="text" id="address.state" name="address.state" path="address.state" /></td>
	<td><form:errors path="address.state" cssStyle="color: #ff0000;" /></td>
	<td></td>
	</tr>
	
	<tr>
	<td><form:label path="address.zipcode"><spring:message code="label.zipcode" /></form:label></td>
	<td><form:input type="text" id="address.zipcode" name="address.zipcode" path="address.zipcode" /></td>
	<td><form:errors path="address.zipcode" cssStyle="color: #ff0000;" /></td>
	<td></td>
	</tr>
	
	<tr>
	
	<td><form:label path="address.country"><spring:message code="label.country" /></form:label></td>
	<td><form:input type="text" id="address.country" name="address.country" path="address.country" /></td>
	<td><form:errors path="address.country" cssStyle="color: #ff0000;" /></td>
	<td></td>
	</tr>
	
	<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>

			<tr>
				<td></td>
				
				<td><form:button id="register" name="register">Register</form:button></td>
				<td></td>
			</tr>

			<tr>
				<td></td>
				<td>
				<label for="">Already Registered ??</label>
					<a href="login">
						<b>Login Here</b>
					</a>
				</td>
				<td></td>
			</tr>
		
	</table>
	
	
</form:form>


</body>
</html> 