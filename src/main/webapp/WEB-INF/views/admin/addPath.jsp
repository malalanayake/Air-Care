<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Path</title>
</head>
<body>
	<c:import url="/WEB-INF/views/layout/_header.jsp"></c:import>

	<div class="content-section">
		<div class="container">
			<h2 class="section-heading">
				<spring:message code="addSchedule.title.label" />
				<br />
			</h2>

			<form:form commandName="newPath" class="form-horizontal">

				<fieldset>
					<form:errors path="*" cssClass="alert alert-danger" element="div" />
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="airportIn"><spring:message
								code="path.form.airportIn.label" /></label>
						<div class="col-lg-10">
							<form:input type="text" id="airportIn" path="airportIn.name"
								value="" onkeyup="madeAjaxCall('airportIn');" />
							<form:errors path="airportIn.name" cssClass="text-danger" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="airportOut"><spring:message
								code="path.form.airportOut.label" /></label>
						<div class="col-lg-10">
							<form:input type="text" id="airportOut" path="airportOut.name"
								value="" onkeyup="madeAjaxCall('airportOut');" />
							<form:errors path="airportOut.name" cssClass="text-danger" />
						</div>
					</div>


					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<input type="submit" id="btnSumbit" class="btn btn-primary"
								value="<spring:message code="path.submit.button" />" />
						</div>
					</div>

					<c:url value="/airport" var="baseurl"></c:url>
					<input id="baseurl" type="hidden" value="${baseurl}" />

				</fieldset>
			</form:form>
		</div>
	</div>
	<c:import url="/WEB-INF/views/layout/_footer.jsp"></c:import>
	<script src="<c:url value="/resources/js/aircare.js" />"></script>
</body>
</html>