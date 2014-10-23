<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
</head>
<body>
	<c:import url="/WEB-INF/views/layout/_header.jsp"></c:import>

	<div class="content-section">
		<div class="container">
			<h2 class="section-heading">
				<spring:message code="contact.heading.lable" />
				<br />
			</h2>

			<ul class="list-group">
				<li class="list-group-item"><span class="badge"></span>
					<div class="media">
						<a class="pull-left" href="#"> <img class="media-object"
							src="" alt="">
						</a>
						<div class="media-body">
							<h4 class="media-heading">Amila Nagendirapillai</h4>
							namila23@gmail.com
						</div>
						<a href="https://www.linkedin.com/in/amilanagendirapillai
">www.linkedin.com/in/amilanagendirapillai
						</a>

					</div></li>

				<li class="list-group-item"><span class="badge"></span>

					<div class="media">
						<a class="pull-left" href="#"> <img class="media-object"
							src="" alt="">
						</a>
						<div class="media-body">
							<h4 class="media-heading">Pirasanth Balachandran</h4>
							bpirasanth@gmail.com
						</div>
						<a href="https://www.linkedin.com/in/bpirasanth">www.linkedin.com/in/bpirasanth</a>
					</div></li>


				<li class="list-group-item"><span class="badge"></span>
					<div class="media">
						<a class="pull-left" href="#"> <img class="media-object"
							src="" alt="">
						</a>
						<div class="media-body">
							<h4 class="media-heading">Dinuka Malalanayake</h4>
							dinuka.malalanayake@gmail.com
						</div>
						<a href="https://www.linkedin.com/in/malalanayake">https://www.linkedin.com/in/malalanayake</a>
						<br /> <a href="http://malalanayake.wordpress.com/">http://malalanayake.wordpress.com/</a>
					</div></li>
			</ul>
		</div>
	</div>

	<c:import url="/WEB-INF/views/layout/_footer.jsp"></c:import>
</body>
</html>
