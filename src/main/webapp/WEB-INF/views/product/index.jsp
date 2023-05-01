<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QR Code</title>
</head>
<body>

	<h3>Product List</h3>
	<table border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Status</th>
			<th>BarCode</th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.quantity }</td>
				<td>${product.status }</td>
				<td>
					<img src="${pageContext.request.contextPath }/product/barcode/${product.id }" width="200" height="50">
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>