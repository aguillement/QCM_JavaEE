$(document).ready(function() {
	const url = $("#passExamUrl").val();
	$('#btnCommencer').on('click', function() {
		var content = 'Voulez-vous vraiment commencer le test ?';
		if ($('#btnCommencer').hasClass("inUse")) {
			content = 'Voulez-vous vraiment reprendre le test ?';
		}
		$.alert({
			title : 'Attention!',
			type : "red",
			content : content,
			buttons : {
				oui : function() {
					$(location).attr("href", url);
				},
				non : function() {
				}
			}
		});

	});
});