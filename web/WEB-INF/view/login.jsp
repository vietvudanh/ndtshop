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
	<div class='header'>Please login</div>
	
	<div class='container'>
		<div class="message">
			<c:choose>
				<c:when test="${message != null}">
					<c:out value="${message}" />
				</c:when>
			</c:choose>
		</div>
		<form action="${contextPath}/login" name="login-form" method="post" class="">
			<label for="username">Username</label>
			<input name="username" type="text" />
			<br>
			<label for="password">Password</label>
			<input name="password" type="text" />
			<input type="submit" value="Login">
		</form>
		<a href="${contextPath}/register">Register</a>
	</div>

</body>
</html>