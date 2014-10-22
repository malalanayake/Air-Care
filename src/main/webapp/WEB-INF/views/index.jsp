<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
<title>Client Home</title>
<link
	href="<c:url value="/resources/js/datepicker/css/datepicker.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/jqgrid/ui.jqgrid.css"/>"
	rel="stylesheet" />
<style>
html, body, #map-canvas {
	height: 50%;
	margin: 0px;
	padding: 0px;
	margin: 0px;
}
</style>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
<script>
	function initialize() {

		var mapOptions = {
			zoom : 5,
			center : new google.maps.LatLng(37.09024, -95.71289100000001),
			mapTypeId : google.maps.MapTypeId.TERRAIN
		};

		var map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);

		var flightPlanCoordinates = [
				new google.maps.LatLng(41.974162, -87.90732100000002),
				new google.maps.LatLng(41.534133, -93.658796),
				new google.maps.LatLng(41.991943, -93.62194799999997),
				new google.maps.LatLng(33.640728, -84.42770000000002) ];
		var flightPath = new google.maps.Polyline({
			path : flightPlanCoordinates,
			geodesic : true,
			strokeColor : '#FF0000',
			strokeOpacity : 1.0,
			strokeWeight : 3
		});

		flightPath.setMap(map);

	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
	<c:import url="/WEB-INF/views/layout/_header.jsp"></c:import>
	<div id="map-canvas"></div>
	<div class="content-section">
		<div class="container">
			<div>
				<div class="row">
					<div class="col-lg-6">
						<label for="lastName"><spring:message text="Origin" /></label>
						<div>
							<input type="text" id="originSearch" value=""
								onkeyup="madeAjaxCall('originSearch');">
						</div>
					</div>

					<div class="col-lg-6">
						<label for="lastName"><spring:message text="Distination" /></label>
						<div>
							<input type="text" id="destinationSearch" value=""
								onkeyup="madeAjaxCall('destinationSearch');">
						</div>
					</div>

					<div class="col-lg-6">
						<label for="departureDate"><spring:message
								text="Departure Date" /></label>
						<div>
							<input type="text" id="departureDate" value="">
						</div>
					</div>

					<div class="col-lg-6">
						<label for="arrivalDate"><spring:message
								text="Arrival Date" /></label>
						<div>
							<input type="text" value="" id="arrivalDate">
						</div>
						<br />
					</div>

					<div class="col-lg-6">
						<div>
							<input type="submit" id="btnSearch" class="btn btn-primary"
								value="<spring:message text="Search" />"
								onclick="generateGrid();" />
						</div>
						<br /> <br />
					</div>

					<div class="col-lg-12">
						<div>
							<table id="grid_id">
							</table>
						</div>
						<div id="gridpager"></div>
					</div>

				</div>
			</div>

			<c:url value="/airport" var="baseurl"></c:url>
			<input id="baseurl" type="hidden" value="${baseurl}" />

		</div>
	</div>
	<c:import url="/WEB-INF/views/layout/_footer.jsp"></c:import>
	<script
		src="<c:url value="/resources/js/datepicker/js/bootstrap-datepicker.js" />"></script>
	<script src="<c:url value="/resources/js/datepicker/datepicker.js" />"></script>
	<script src="<c:url value="/resources/js/jqgrid/grid.locale-en.js" />"></script>
	<script
		src="<c:url value="/resources/js/jqgrid/jquery.jqGrid.min.js" />"></script>
	<script src="<c:url value="/resources/js/aircare.js" />"></script>
</body>
</html>
