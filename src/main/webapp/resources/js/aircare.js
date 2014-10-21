/**
 * 
 */

var availableAirports = [];

function madeAjaxCall(identifier) {
	var filter = $("#" + identifier).val()
	var baseurl = $("#baseurl").val();
	$.ajax({
		url : baseurl + "/getFilteredAirports",
		type : "post",

		cache : false,
		data : 'filter=' + filter,
		success : function(response) {
			//console.log(response);
			availableAirports = response.split(':');
			console.log(availableAirports);
			refreshOriginSearch(identifier);
		},
		error : function(e) {
			// console.log(e);
			alert('Error while request..');
		}
	});
}

$(function(identifier) {
	$("#" + identifier).autocomplete({
		source : availableAirports
	});
});

function refreshOriginSearch(identifier) {
	$("#" + identifier).autocomplete({
		source : availableAirports
	});
}