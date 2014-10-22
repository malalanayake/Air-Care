<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src='http://maps.google.com/maps/api/js?sensor=false&libraries=places'></script>
<script
	src="<c:url value="/resources/js/map/locationpicker.jquery.js"  />"></script>
</head>
<body>
	<c:import url="/WEB-INF/views/layout/_header.jsp"></c:import>

	<div class="content-section">
		<div class="container">
			<h2 class="section-heading">
				<spring:message code="register.airport.title" />
				<br />
			</h2>
		</div>
		<c:url value="/airport/add" var="addURL"></c:url>
		<form:form method="post" commandName="newAirport" action="${addURL}"
			class="form-horizontal">
			<fieldset>
				<form:errors path="*" cssClass="alert alert-danger" element="div" />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name"><spring:message
							code="register.airport.name" /></label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" />
						<form:errors path="name" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="location"><spring:message
							code="register.airport.location" /></label>
					<div class="col-lg-10">
						<form:input type="text" path="location" id="location"
							style="width: 250px" />
						<br />
						<div id="us2" style="width: 250px; height: 200px;"></div>

					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="latitude"><spring:message
							code="register.airport.latitude" /></label>
					<div class="col-lg-10">
						<form:input disabled="true" type="text" path="latitude"
							id="latitude" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="longitude"><spring:message
							code="register.airport.longitude" /></label>
					<div class="col-lg-10">
						<form:input disabled="true" type="text" path="longitude"
							id="longitude" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							text="" /></label>
					<div class="col-lg-10">
						<form:button id="submit" class="btn btn-primary"
							value="Register Airport" name="Register Airport">
							<spring:message code="register.airport.registerbutton" />
						</form:button>
					</div>
				</div>

				<script>
					$('#us2').locationpicker({
						location : {
							latitude : 41.534133,
							longitude : -93.658796
						},
						radius : 0,
						zoom : 15,
						inputBinding : {
							latitudeInput : $('#latitude'),
							longitudeInput : $('#longitude'),
							locationNameInput : $('#location')
						},
						enableAutocomplete : true,
						enableReverseGeocode : true,
					});
				</script>
			</fieldset>
		</form:form>
	</div>

	<c:import url="/WEB-INF/views/layout/_footer.jsp"></c:import>
</body>
</html>
