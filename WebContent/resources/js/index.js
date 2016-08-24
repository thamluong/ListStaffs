$(document).ready(function() {
	$('select').on('click', function(){
		var cid = $(".listCompany").val();

		$('#table_div').load('staffs-acompany .table', 'company_id=' +$('.listCompany').val(), function(){
			var table1 = $('#table').DataTable({
				"lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
				"drawCallback": function(){

					$(".add-liststaff").attr("class","btn btn-info btn-lg add-liststaff2");
				/*	$('.add-liststaff2').on("click", function () {
						$(".modal-title").text("NEW STAFF");
						$(".modal-title").css({"color": "#0099cc", "font-weight": "bold", "text-align":"center", "font-family":"ANTICLIMAX"})
						$(".modal-footer").load("add-staff.html .button-modal", function () {
							$('#send-2').on('click',function() {
								$.post("add.html", {
									id_company : $('#id-2').val(),
									id_staff: "1",
									name_staff: $("#name-2").val(),
									info_staff: $("#info-2").val(),
									avatar_staff:$("#avatar-2").val(),
									name_company: ""
								}, function (data) {
									var elt = document.getElementById("id-2");
									if(cid == $('#id-2').val()){
										table1.row.add([
										                elt.options[elt.selectedIndex].text,
										                data,
										                "<span class='name-22'>" +$("#name-2").val() + "</span>",
										                "<a data-toggle='modal' data-target='#myModal_1' class ='detail'><button type='button' class='btn btn-success'>Detail</button></a>",
										                "<button class='delete_button'>Delete</button>"
										                ]).draw(false);
									}
									$(".close").click();
								}); }); }); });	*/
					$('.add-liststaff2').on('click', function(){
						$('.div-add').load('http://localhost:8080/Staffs/StaffService/search-service.html', function(){
							$('#div-table-search').modal("toggle");
							$('#add-search-form').click(function () {
								$('.close').on('click',function() {
									window.open('add-staff-service', '_self');
								}); }); }); });

					$('.detail').on("click", function () {
						var id = $(this).parents('tr').children('td').eq(1).text().trim();
						$(".modal-title").text("Detail Information");
						$(".modal-body").load("detail_file.html .table", "id=" + id);
						$(".modal-footer").load("detail_file.html .button-modal", "id=" + id, function () {
							$('#close-button').on('click', function () {
								table1.$('tr.selected').removeClass('selected');
							}); }); });

					$('.delete_button').on('click', function(){
						var id = $(this).parents('tr').children('td').eq(1).text().trim();
						$(this).parents('tr').addClass("deleted");
						$.get("delete.html", "id=" + id, function () {
							table1.row('.deleted').remove().draw(false);
						}); }); 

				}}); }); 
		});


	var table = $('#table').DataTable({
		"lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
		"drawCallback": function () {

			$('.detail').on("click", function () {
				var id = $(this).parents('tr').children('td').eq(1).text().trim();
				$(".modal-title").text("Detail Information");
				$(".modal-body").load("detail_file.html .table", "id=" + id);
				$(".modal-footer").load("detail_file.html .button-modal", "id=" + id, function () {
					$('#close-button').on('click', function () {
						table.$('tr.selected').removeClass('selected');
					}); }); });

			$('.delete_button').on('click', function(){
				var id = $(this).parents('tr').children('td').eq(1).text().trim();
				$(this).parents('tr').addClass("deleted");
				$.get("delete.html", "id=" + id, function () {
					table.row('.deleted').remove().draw(false);
				}); });

			$('.add-liststaff').on('click', function(){
				$('.div-add').load('http://localhost:8080/Staffs/StaffService/search-service.html', function(){
					$('#div-table-search').modal("toggle");
					$('#add-search-form').click(function () {
						$('.close').on('click',function() {
							window.open('add-staff-service', '_self');
						}); }); }); });
		}});
});

