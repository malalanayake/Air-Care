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
</head>
<body>
	<c:import url="/WEB-INF/views/layout/_header.jsp"></c:import>

	<div class="content-section">
		<div class="container">
			<h2 class="section-heading">
				Welcome to Air Care<br>
			</h2>

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
