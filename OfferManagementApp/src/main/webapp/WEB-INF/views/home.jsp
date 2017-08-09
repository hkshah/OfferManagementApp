<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h3>Product List</h3>
	<c:url var="addProduct" value="/addProduct"></c:url>
	<form:form action="${addProduct}" commandName="addProduct">
		<table>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Add Product"/>" /></td>
			</tr>
		</table>
	</form:form>
	<c:if test="${!empty productList}">
		<table class="tg">
			<tr>
				<th width="80">#</th>
				<th width="120">Code</th>
				<th width="120">Name</th>
				<th width="120">Stock</th>
				<th width="120">Created On</th>
				<th width="120">Offers</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.code}</td>
					<td>${product.name}</td>
					<td>${product.stock}</td>
					<td><fmt:formatDate value="${product.createdOn}" type="date"
							pattern="MM/dd/yyyy" /></td>
					<td><c:forEach var="offers" items="${product.offerList}">
							<li>${offers}</li>
						</c:forEach></td>
					<td><a href="<c:url value='/edit/product/${product.id}' />">Edit</a></td>
					<td><a href="<c:url value='/delete/product/${product.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>



	<h3>Offer List</h3>
	<c:url var="addoffer" value="/addOffer"></c:url>
	<form:form action="${addoffer}" commandName="addOffer">
		<table>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Add Offer"/>" /></td>
			</tr>
		</table>
	</form:form>
	<c:if test="${!empty offerList}">
		<table class="tg">
			<tr>
				<th width="80">#</th>
				<th width="120">Code</th>
				<th width="120">Start Date</th>
				<th width="120">End Date</th>
				<th width="120">Discount</th>
				<th width="120">Type</th>
				<th width="120">Product</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${offerList}" var="offer">
				<tr>
					<td>${offer.id}</td>
					<td>${offer.code}</td>
					<td><fmt:formatDate value="${offer.startDate}" type="date"
							pattern="MM/dd/yyyy" /></td>
					<td><fmt:formatDate value="${offer.endDate}" type="date"
							pattern="MM/dd/yyyy" /></td>
					<td>${offer.discount}</td>
					<td>${offer.type}</td>
					<td>${offer.product}</td>
					<td><a href="<c:url value='/edit/offer/${offer.id}' />">Edit</a></td>
					<td><a href="<c:url value='/delete/offer/${offer.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>
