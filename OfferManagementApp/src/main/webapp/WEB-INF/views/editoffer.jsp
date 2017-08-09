<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Edit Offer</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		$('.idDateField').datepicker();
	});
</script>
</head>
<body>
	<h1>Edit Offer</h1>

	<c:url var="addOffer" value="/update/offer"></c:url>

	<form:form action="${addOffer}" commandName="offerdetails">
		<table>
			<tr>
				<td><form:label path="id">
						<spring:message text="ID" />
					</form:label></td>
				<td><form:input path="id" readonly="true" disabled="true" /> <form:hidden
						path="id" /></td>
			</tr>
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
				<td><form:input class="idDateField" path="startDate"
						patter="DD-MM-YYYY" /></td>
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
						<form:options items="${offerdetails.productList}" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Edit"/>" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
