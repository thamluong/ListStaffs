$(document).ready(function(){
	$('#home').click(function(){
		$(window).load('/');
	})
	
	var table = $('#table-add').DataTable({
		"lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
		"drawCallback": function(){

			$('#update-db').click(function () {
				if ($('.name').val() == null) alert("No data to update.");
				else $(window).load("updateDbByWS", function(){
					alert("Successfully add to database.");
					window.location.href = 'null-add-staff';
				});	});

			$('#cancel').click(function(){
				window.location.href = 'null-add-staff';
			});

			$('.add-liststaff').on('click', function(){
				$('.div-add').load('http://localhost:8080/Staffs/StaffService/search-service.html', function(){
					$('#div-table-search').modal("toggle");
					$('.close').on('click',function() {
						window.open('add-staff-service', '_self');
					});	}); });
		}});

	if($('.staff-existed').val() != null) {
		alert("Data duplicated");
		$('#div-existed').show();
	}
});

