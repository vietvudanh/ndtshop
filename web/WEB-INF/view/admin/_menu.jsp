<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<ul class="list-group" id="admin-menu">
  <li class="list-group-item"><a href="${contextPath}/admin/users">Manage user</a></li>
  <li class="list-group-item"><a href="${contextPath}/admin/products">Manage products</a></li>
  <li class="list-group-item">Manage categories</li>
  <li class="list-group-item">Porta ac consectetur ac</li>
  <li class="list-group-item">Vestibulum at eros</li>
</ul>


<script>
	var url = window.location.pathname;
   	var urlRegExp = new RegExp(url.replace(/\/$/,'')); 
	$('#admin-menu li a').each(function(){
        if(urlRegExp.test(this.href)){
			$(this).addClass('active');
        }
    });
</script>