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
			availableAirports = response;
			refreshOriginSearch(identifier);
		},
		error : function(e) {
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

function search() {
	var origin = $("#originSearch").val();
	var destination = $("#destinationSearch").val();
	var departureDate = $("#departureDate").val();
	var baseurl = $("#scheduleurl").val();
	
	$.ajax({
		url : baseurl + "/getFilteredSchedules",
		type : "post",
		cache : false,
		data : 'origin=' + origin + "&destination="
		+ destination + "&departureDate=" + $("#departureDate").val(),
		success : function(response) {
			console.log(response)
		},
		error : function(response) {
			console.log(e);
			alert('Error while request..');
		}
	});
}

