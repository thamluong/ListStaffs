<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>

<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
<script type="text/javascript"
	src="<c:url value="/resources/js/index.js" />"></script>

</head>
<body>
	<br>
	<table style="border: 5px; name: addstaff-table;" class="table">
		<tr>
			<td><b>Company</b></td>
			<td>
				<select	id="id-2" class="listCompany">
					<c:forEach var="company" items="${listCompany}" varStatus="status">
						<option value='${company.id_company}'>${company.name_company}</option>
					</c:forEach>

			</select>
			</td>
		</tr>
		<tr>
			<td><b>Staff</b></td>
			<td><input type="text" name="age" id="name-2" /></td>
		</tr>
		<tr>
			<td><b>Information</b></td>
			<td>
				<!-- <input type="text" name="role" id="info-2"/> --> <textarea
					id="info-2" rows="5" style="width: 100%"></textarea>
			</td>
		</tr>
		<tr>
			<td><b>Avatar</b></td>
			<td><input type="text" name="address" id="avatar-2" /></td>
		</tr>
	</table>
	<table class="button-modal" style="width: 100%">
		<tr>
			<td width="50%" align="left"><button type="button"
					class="btn btn-default" id="send-2">Send</button></td>
			<td width="50%" align="right"><button type="button"
					class="btn btn-default" data-dismiss="modal" id="close-button">Close</button></td>
		</tr>
	</table>
</body>
</html>
