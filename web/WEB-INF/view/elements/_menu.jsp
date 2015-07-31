<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:choose>
	<c:when test="${sessionScope.user != null}">
		Logged in as ${sessionScope.customername}
		<a href="${contextPath}/logout">Logout</a>
	</c:when>
	<c:otherwise><a href="${contextPath}/login">Login</a></c:otherwise>
</c:choose>


<c:if test="${sessionScope.role != null and sessionScope.role == 'admin' }">
	<a href="${contextPath}/admin">Admin</a>
</c:if>
