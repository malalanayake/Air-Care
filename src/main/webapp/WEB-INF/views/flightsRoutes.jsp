<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
html, body, #map-canvas {
	height: 80%;
	margin: 0px;
	padding: 0px;
	margin: 0px;
}
</style>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
<script>
	// This example creates a 2-pixel-wide red polyline showing
	// the path of William Kingsford Smith's first trans-Pacific flight between
	// Oakland, CA, and Brisbane, Australia.

	var line;
	function initialize() {

		var mapOptions = {
			zoom : 5,
			center : new google.maps.LatLng(37.09024, -95.71289100000001),
			mapTypeId : google.maps.MapTypeId.TERRAIN
		};

		var map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);

		var lineCoordinates = [
				new google.maps.LatLng(41.974162, -87.90732100000002),
				new google.maps.LatLng(41.534133, -93.658796),
				new google.maps.LatLng(41.991943, -93.62194799999997),
				new google.maps.LatLng(33.640728, -84.42770000000002) ];

		// Define the symbol, using one of the predefined paths ('CIRCLE')
		// supplied by the Google Maps JavaScript API.
		var lineSymbol = {
			path : google.maps.SymbolPath.FORWARD_CLOSED_ARROW,
			scale : 3,
			strokeColor : '#FF0000'
		};

		// Create the polyline and add the symbol to it via the 'icons' property.
		line = new google.maps.Polyline({
			path : lineCoordinates,
			icons : [ {
				icon : lineSymbol,
				offset : '100%',
			} ],
			map : map
		});

		animateCircle();

		/* var mapOptions = {
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
		 */
	}

	// Use the DOM setInterval() function to change the offset of the symbol
	// at fixed intervals.
	function animateCircle() {
		var count = 0;
		window.setInterval(function() {
			count = (count + 1) % 200;

			var icons = line.get('icons');
			icons[0].offset = (count / 2) + '%';
			line.set('icons', icons);
		}, 100);
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
	<c:import url="/WEB-INF/views/layout/_header.jsp"></c:import>
	<div id="map-canvas"></div>
	<c:import url="/WEB-INF/views/layout/_footer.jsp"></c:import>
</body>
</html>
