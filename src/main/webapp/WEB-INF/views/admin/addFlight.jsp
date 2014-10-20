<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Registration</title>
</head>
<body>
	<c:import url="/WEB-INF/views/layout/_header.jsp"></c:import>

	<div class="content-section">
		<div class="container">
			<h2 class="section-heading">
				Flight Registration<br>
			</h2>

			<form:form commandName="newFlight" class="form-horizontal">
				<fieldset>
					<form:errors path="*" cssClass="alert alert-danger" element="div" />

					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="airline"><spring:message
								text="AirLine Name" /></label>
						<div class="col-lg-10">
							<form:input id="airline" path="airline" type="text" />
							
							<form:select path="airline">
								<form:options items="${airlines}" />
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="flightNumber"><spring:message
								text="Flight Number" /></label>
						<div class="col-lg-10">
							<form:input id="flightNumber" path="flightNumber" type="text" />
							<form:errors path="flightNumber" cssClass="text-danger" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<input type="submit" id="btnSumbit" class="btn btn-primary"
								value="Sumbit" />
						</div>
					</div>



				</fieldset>
			</form:form>
		</div>
	</div>

	<c:import url="/WEB-INF/views/layout/_footer.jsp"></c:import>
</body>
</html>