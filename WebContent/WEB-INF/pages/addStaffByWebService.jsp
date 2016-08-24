<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Staff By WebServicee</title>

<script type="text/javascript" charset="UTF-8"
	src="//code.jquery.com/jquery-1.12.3.min.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<%-- <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet"> --%>
<script type="text/javascript"
	src="<c:url value="/resources/js/addStaffByWebService.js" />"></script>
</head>
<body>
	<div class='container'>
		<div id='div-add'>
			<div align="center"
				style="font-family: vffree14; color: #006600; font-size: 80px">
				Add staffs service <br>
			</div>
			<br> <a href='http://localhost:8080/ListStaffs/' id='home'
			style='color:purple;font-weight:bold;text-decoration:underline;'>Home</a>
			<table id='table-add'>
				<thead>
					<tr style='text-weight: bold;'>
						<th></th>
						<th>Company</th>
						<th>Fullname</th>
						<th>Infomation</th>
						<th style='display: none;'>Avatar</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var='staff' items='${staffs_addByWS}' varStatus='status'>
						<tr>
							<td>${status.index +1}</td>
							<td>${staff.name_company}</td>
							<td class='name' style='cursor: pointer;'>${staff.name_staff}</td>
							<td>${staff.info_staff}</td>
							<td style='display: none;'>${staff.avatar_staff}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<button type="button" id='update-db'
				class="btn btn-default btn-success">Update DB</button>
			<button type="button" id='cancel' class="btn btn-default btn-success">Cancel</button>
			<button type="button" id='add-add' style="float: right;"
				class="add-liststaff btn btn-default btn-success"
				data-toggle="modal" data-target="#div-table-search">Add</button>
		</div>
		
		
		<div class="div-add"></div>
		<br> <br>
		<div id='div-existed'
			style='display: none; background-color: #ffcc99; text-align: justify; width: 100%; resize: none;'>
			<c:if test="${not empty staffs2}">
				<h4>Data duplicate:</h4>
				<c:forEach var='staff' items='${staffs2}' varStatus='status'>
					<p class='staff-existed' style='padding-left:3em;'>[ ${staff.name_staff},
						${staff.name_company}, ${staff.info_staff}]</p>
						<br>
				</c:forEach>
			</c:if>
		</div>
	</div>
</body>
</html>