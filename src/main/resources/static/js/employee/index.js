/**
 * 
 */

$(document).on('click', '.delete', function() {
	var emp_id = $(this).attr('data-id');
	console.log(emp_id)
	Swal.fire({
		title: "Delete_Confirm",
		text: "Delete_Message",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#d93535',
		confirmButtonText: "Delete_button",
		cancelButtonText: 'Close'
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
				headers: {
					'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
				},
				url: "/employee/delete/" + emp_id,
				type: 'DELETE',
				contentType: 'application/json',
				data: {
					"id": emp_id,
					'_token': '{{csrf_token()}}'
				},
				success: function(data) {
					location.reload();

				},
				error: function(data) {
					console.log(data)
				
				}
			})
		}
	})
});