<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staffs List</title>

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
<script type="text/javascript"
	src="<c:url value="/resources/js/index.js" />"></script>
<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">

</head>
<body>
	<div class='container'>
		<div align="center" style="color: #6666ff">
			<h1>
				<strong>Staffs List</strong>
			</h1>
			<br><br>
		</div>

		<select class="listCompany">
			<option value="0" selected>All</option>
			<c:forEach var="company" items="${listCompany}" varStatus="status">
				<option value='${company.id_company}'>${company.name_company}</option>
			</c:forEach>
		</select> <br> <br>

		<div id='table_div'>
			<table id='table' class="table" style="name: main-table">
				<thead>
					<tr bgcolor="#DEB887">
						<!-- <th><strong>Company</strong></th> -->
						<th><b>Company</b></th>
						<th><b>ID</b></th>
						<th><b>Staff</b></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="staff" items="${listStaff}" varStatus="status">
						<tr>
							<td>${staff.name_company}</td>
							<td>${staff.id_staff}</td>
							<td><label class="get_name">${staff.name_staff}</label></td>
							<td><button type="button" class="detail btn btn-success"
									data-toggle="modal"	data-target="#myModal_1">Detail</button>
							</td>
							<td><button class='delete_button'>Delete</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<button type="button" class="btn btn-info btn-lg add-liststaff"
			data-toggle="modal" data-target="#div-table-search">Add</button>
		<div class="div-add"></div>
		
			<!-- <div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h2 class="modal-title"></h2>
					</div>
					<div class="modal-body"></div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div> -->
	</div>
</body>
</html>