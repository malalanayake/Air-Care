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
			// console.log(availableAirports);			
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

function generateGrid() {
    jQuery("#grid_id").jqGrid(
                    {
                            url : 'post-json.json',
                            datatype : "json",
                            colNames : [ 'Origin', 'Distination', 'Departure Date' ],
                            colModel :
                                    [
                                            {name : 'amount', index : 'amount', align : "right"},
                                            {name : 'tax', index : 'tax', align : "right" },
                                            {name : 'note', index : 'note', sortable : false}
                                    ],
                            rowNum : 10,
                            rowList : [ 10, 20, 30 ],
                            pager : '#gridpager',
                            sortname : 'id',
                            sortorder : "desc",
				            multiselect : false
                    }
    );
}