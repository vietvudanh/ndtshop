<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/signin.css" rel="stylesheet" type="text/css"/>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:import url="/WEB-INF/view/elements/_menu.jsp" />
	<div class='header'></div>
	
	<div class='container'>
		
		<form class="form-signin" method="post" action="${contextPath}/login">
			<div class="message">
				<c:choose>
					<c:when test="${message != null}">
						<c:out value="${message}" />
					</c:when>
				</c:choose>
			</div>
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Username</label>
			<input type="text" name="username" id="input-username" class="form-control" placeholder="Username" required="" autofocus="">
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" name="password" id="password" class="form-control" placeholder="Password" required="">
			<div class="checkbox">
			  <label>
			    <input type="checkbox" value="remember-me"> Remember me
			  </label>
			</div>
			<input class="btn btn-lg btn-primary btn-block" type="submit" value="Login">
			<a href="${contextPath}/register">Register</a>
		</form>
		
	</div>

</body>
</html>