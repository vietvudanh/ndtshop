<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>

<script type="text/javascript" src="js/move-top.js"></script>
</head>
<body>
	<div class='header'>This is header</div>
	<div>Logged in as ${sessionScope.user}</div>
	
	<div class='container'>
		<table style="border:solid 1px;">	
			<c:forEach items="${products}" var="product">
				<tr>
					<td><c:out value="${product.productname}"/></td>
					<td><c:out value="${product.productdescription}"/></td>
					<td><c:out value="${product.productsaleprice}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="footer"><c:import url='elements/_footer.jsp'></c:import></div>
</body>
</html>