<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Schedule</title>
<link
	href="<c:url value="/resources/js/datepicker/css/datepicker.css"/>"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css" media="screen"
	href="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/master/build/css/bootstrap-datetimepicker.min.css" />
</head>
<body>
	<c:import url="/WEB-INF/views/layout/_header.jsp"></c:import>

	<div class="content-section">
		<div class="container">
			<h2 class="section-heading">
				<spring:message code="addSchedule.title.label" />
				<br>
			</h2>


			<form:form commandName="newSchedule" class="form-horizontal">
				<fieldset>
					<form:errors path="*" cssClass="alert alert-danger" element="div" />

					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="path"><spring:message
								code="addSchedule.form.path.label" /></label>
						<div class="col-lg-10">
							<form:select path="path.id">
								<c:forEach var="pathName" items="${pathNames}">
									<form:option value="${pathName.key}">${pathName.value}</form:option>
								</c:forEach>

							</form:select>
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="date"><spring:message
								code="addSchedule.form.date.label" /></label>
						<div class="col-lg-10" id='datetimepicker'>
							<form:input id="date" path="date" type="text" />
							<i class="glyphicon glyphicon-calendar"></i>
							<form:errors path="date" cssClass="text-danger" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="seatCount"><spring:message
								code="addSchedule.form.seatCount.label" /></label>
						<div class="col-lg-10">
							<form:input id="seatCount" path="seatCount" type="text" />
							<form:errors path="seatCount" cssClass="text-danger" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<input type="submit" id="btnSumbit" class="btn btn-primary"
								value="<spring:message code="addSchedule.add.button" />" />
						</div>
					</div>



				</fieldset>
			</form:form>
		</div>
	</div>

	<c:import url="/WEB-INF/views/layout/_footer.jsp"></c:import>
	<script
		src="<c:url value="/resources/js/datepicker/js/bootstrap-datepicker.js" />"></script>
	<script src="<c:url value="/resources/js/datepicker/js/moment.js" />"></script>

	<script type="text/javascript"
		src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/master/src/js/bootstrap-datetimepicker.js"></script>
	<script src="<c:url value="/resources/js/datepicker/datepicker.js" />"></script>

	<script type="text/javascript">
		$(function() {
			$('#datetimepicker').datetimepicker();
		});
	</script>

</body>
</html>
