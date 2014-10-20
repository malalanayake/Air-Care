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
</head>
<body>
	<c:import url="/WEB-INF/views/layout/_header.jsp"></c:import>

	<div class="content-section">
		<div class="container">
			<h2 class="section-heading">
				Add Passenger<br>
			</h2>

			<form:form commandName="newPassenger" class="form-horizontal">
				<fieldset>
					<form:errors path="*" cssClass="alert alert-danger" element="div" />

					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="firstName"><spring:message
								text="First Name" /></label>
						<div class="col-lg-10">
							<form:input id="firstName" path="firstName" type="text" />
							<form:errors path="firstName" cssClass="text-danger" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="lastName"><spring:message
								text="Last Name" /></label>
						<div class="col-lg-10">
							<form:input id="lastName" path="lastName" type="text" />
							<form:errors path="lastName" cssClass="text-danger" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2"
							for="passportNumber"><spring:message
								text="Your Passpost Number" /></label>
						<div class="col-lg-10">
							<form:input id="passportNumber" path="passportNumber" type="text" />
							<form:errors path="passportNumber" cssClass="text-danger" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="emailAddress"><spring:message
								text="Your Email Address" /></label>
						<div class="col-lg-10">
							<form:input id="emailAddress" path="emailAddress" type="text" />
							<form:errors path="emailAddress" cssClass="text-danger" />
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