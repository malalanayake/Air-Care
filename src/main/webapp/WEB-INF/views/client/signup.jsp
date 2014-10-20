<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<c:import url="/WEB-INF/views/layout/_header.jsp"></c:import>
	<div class="content-section">
		<div class="container">
			<h2 class="section-heading">
				Sign Up<br>
			</h2>

			<form:form commandName="newUser" class="form-horizontal">
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
						<label class="control-label col-lg-2 col-lg-2" for="username"><spring:message
								text="User Name" /></label>
						<div class="col-lg-10">
							<form:input id="username" path="username" type="text" />
							<form:errors path="username" cssClass="text-danger" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="password"><spring:message
								text="Password" /></label>
						<div class="col-lg-10">
							<form:password id="password" path="password" showPassword="true" />
							<form:errors path="password" cssClass="text-danger" />
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2"
							for="passwordConfirm"><spring:message
								text="Confirm your Password" /></label>
						<div class="col-lg-10">
							<form:password id="passwordConfirm" path="passwordConfirm"
								showPassword="true" />
							<form:errors path="passwordConfirm" cssClass="text-danger" />
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2"
							for="sequrityQuestion"><spring:message
								text="Please select Sequrity Question" /></label>
						<div class="col-lg-10">
							<form:select path="sequrityQuestion">
								<form:options items="${securityQuestions}" />
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="answer"><spring:message
								text="Your Answer" /></label>
						<div class="col-lg-10">
							<form:password id="answer" path="answer" showPassword="true" />
							<form:errors path="answer" cssClass="text-danger" />
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
