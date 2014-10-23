<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" session="false"%>
<html>
<head>
<title>Client Home</title>
<link
	href="<c:url value="/resources/js/datepicker/css/datepicker.css"/>"
	rel="stylesheet">
<style>
html, body, #map-canvas {
	height: 50%;
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
	<div class="content-section">
		<div class="container">
			<div class="container">
				<h2 class="section-heading">
					<spring:message code="welcom.msg" />
					<br />
				</h2>
			</div>
			<div>
				<div class="row">
					<div class="col-lg-3">
						<label for="originSearch"><spring:message
								code="index.originSearch.label" /></label>
						<div>
							<input type="text" id="originSearch" value=""
								onkeyup="madeAjaxCall('originSearch');">
						</div>
					</div>

					<div class="col-lg-3">
						<label for="destinationSearch"><spring:message
								code="index.destinationSearch.label" /></label>
						<div>
							<input type="text" id="destinationSearch" value=""
								onkeyup="madeAjaxCall('destinationSearch');">
						</div>
					</div>

					<div class="col-lg-3">
						<label for="departureDate"><spring:message
								code="index.departureDate.label" /></label>
						<div>
							<input type="text" id="departureDate" value="">
						</div>
					</div>

					<div class="col-lg-3">
						<label for="arrivalDate"><spring:message
								code="index.arrivalDate.label" /></label>
						<div>
							<input type="text" value="" id="arrivalDate" disabled="disabled">
						</div>
						<br />
					</div>

					<div class="col-lg-3">
						<div>
							<input type="submit" id="btnSearch" class="btn btn-primary"
								onclick="search();"
								value="<spring:message code="index.search.label"  />" />
						</div>
						<br /> <br />
					</div>
				</div>
			</div>

			<div id="result" class="col-lg-8">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Route</th>
							<th>Flight No</th>
							<th>Ari Line Name</th>
							<th>Departure Time</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>Chicago > Ceder Rapids</td>
							<td>UL1234</td>
							<td>Delta</td>
							<td>10/22/2014 5:41 PM</td>
						</tr>
					<tbody>

					</tbody>
				</table>
			</div>

			<div class="col-lg-4" id="map-canvas"></div>
			<c:url value="/airport" var="baseurl"></c:url>
			<input id="baseurl" type="hidden" value="${baseurl}" />

			<c:url value="/schedule" var="scheduleurl"></c:url>
			<input id="scheduleurl" type="hidden" value="${scheduleurl}" />

		</div>
	</div>
	<c:import url="/WEB-INF/views/layout/_footer.jsp"></c:import>
	<script
		src="<c:url value="/resources/js/datepicker/js/bootstrap-datepicker.js" />"></script>
	<script src="<c:url value="/resources/js/datepicker/datepicker.js" />"></script>
	<script src="<c:url value="/resources/js/aircare.js" />"></script>
</body>
</html>
