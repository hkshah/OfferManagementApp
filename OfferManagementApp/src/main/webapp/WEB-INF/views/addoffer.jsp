<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Add Offer</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		$('.idDateField').datepicker();
	});
</script>

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
	<h1>Add Offer</h1>

	<c:url var="addOffer" value="/add/offer"></c:url>

	<form:form action="${addOffer}" commandName="offer">
		<table>
			<tr>
				<td><form:label path="code">
						<spring:message text="Offer Code" />
					</form:label></td>
				<td><form:input path="code" /></td>
			</tr>
			<tr>
				<td><form:label path="startDate">
						<spring:message text="Start Date" />
					</form:label></td>
				<td><form:input class="idDateField" path="startDate" /></td>
			</tr>
			<tr>
				<td><form:label path="endDate">
						<spring:message text="End Date" />
					</form:label></td>
				<td><form:input class="idDateField" path="endDate" /></td>
			</tr>
			<tr>
				<td><form:label path="discount">
						<spring:message text="Discount" />
					</form:label></td>
				<td><form:input path="discount" /></td>
			</tr>
			<tr>
				<td><form:label path="type">
						<spring:message text="Type" />
					</form:label></td>
				<td><form:select path="type">
						<form:option value="%" label="Percentage" />
						<form:option value="Amount" label="Amount" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="product">
						<spring:message text="Product Code" />
					</form:label></td>
				<td><form:select path="product">
						<form:option value="All" label="All" />
						<form:options items="${offer.productList}" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Add Offer"/>" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
