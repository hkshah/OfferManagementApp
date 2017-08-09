<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Edit Product</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		$('#idDateField').datepicker();
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
	<h1>Edit Product</h1>

	<c:url var="editProduct" value="/update/product"></c:url>

	<form:form action="${editProduct}" commandName="productdetails">
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
						<spring:message text="Code" />
					</form:label></td>
				<td><form:input path="code" /></td>
			</tr>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="stock">
						<spring:message text="Stock" />
					</form:label></td>
				<td><form:input path="stock" /></td>
			</tr>
			<tr>
				<td><form:label path="createdOn">
						<spring:message text="Created On" />
					</form:label></td>
				<td><form:input id="idDateField" path="createdOn" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Add"/>" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
