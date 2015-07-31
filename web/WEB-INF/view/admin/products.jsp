<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin product page</title>
<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<c:url value="js/jquery-1.11.0.min.js"/>" ></script>
</head>
<body>

	<div class="row">
		<div class="col-md-3 left">
			<c:import url="_menu.jsp"></c:import>
		</div>
		<div class="col-md-9 right">
			Manage your product here
			<table class="table">
			<tr>
				<th>id</th>
				<th>name</th>
				<th>description</th>
				<th>image</th>
				<th>actions</th>
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td><c:out value="${product.productid}"/></td>
					<td><c:out value="${product.productname}"/></td>
					<td><c:out value="${product.productdescription}"/></td>
					<td><c:out value="${product.productimage}"/></td>
					<td>
						<a href="#" class="btn btn-sm btn-primary">Edit</button>
						<a href="#" class="btn btn-sm btn-danger">Delete</button>
						<a href="#" class="btn btn-sm btn-warning">View</button>
					</td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	
	

</body>
</html>