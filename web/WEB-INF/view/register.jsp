<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register</h1>
	<c:choose>
		<c:when test="${message != null}">
			<c:out value="${message}" />
		</c:when>
	</c:choose>
	<form action="${contextPath}/register" method="post">
		<label for"name">Name: </label>
		<input name="name" type="text" /> </br>
		<label for"username">Username: </label>
		<input name="username" type="text" /> </br>
		<label for"name">Password: </label>
		<input name="password" type="password" /> </br>
		<label for"name">Email: </label>
		<input name="email" type="email" /> </br>
		<input type="submit" value="Register" />
	</form>
</body>
</html>