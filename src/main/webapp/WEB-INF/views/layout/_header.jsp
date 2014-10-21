<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='sec'
	uri='http://www.springframework.org/security/tags'%>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/resources/css/landing-page.css" />"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<c:url value="/resources/font-awesome-4.1.0/css/font-awesome.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<script type="text/javascript">
				function makeAjaxCall(language) {
					var base = $('#lan').val();
					$.ajax({
						type : "post",
						url : base + language,
						cache : false,
						success : function(response) {
							location.reload();
						},
						error : function(e) {
							// console.log(e);
							alert('Error while request..');
						}
					});

				}
			</script>

			<c:url value="/language/" var="lanURL" />
			<input id="lan" type="hidden" value="${lanURL}" />
			<c:url value="/index" var="clienHomeURL" />
			<a class="navbar-brand" href="${clienHomeURL}">Air Care</a> <a
				onclick="makeAjaxCall('en');" class="navbar-brand">English</a>
			<c:url value="/language/ch" var="lanChineseURL" />
			<a onclick="makeAjaxCall('ch');" class="navbar-brand">Chinese</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value="/" />"><i
						class="glyphicon glyphicon-home"></i>Home</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Services</a></li>
				<li><a href="#"><i class="glyphicon glyphicon-envelope"></i>
						Contact </a></li>

				<!-- Client Grated -->
				<sec:authorize ifAnyGranted="ROLE_CLIENT">
					<li><a href="<c:url value="/passenger/add" />"><i
							class="glyphicon glyphicon-plus"></i> Passenger </a></li>
				</sec:authorize>

				<!-- Admin Grated -->
				<sec:authorize ifAnyGranted="ROLE_ADMIN">
					<li><a href="<c:url value="/flight/add" />"><i
							class="glyphicon glyphicon-plane"></i> Flight </a></li>
					<li><a href="<c:url value="/airport/add" />"><i
							class="glyphicon glyphicon-map-marker"></i> Airport </a></li>
				</sec:authorize>

				<!-- Any User logged in -->
				<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
					<li><c:url value="/j_spring_security_logout" var="logoutUrl" />
						<a href="${logoutUrl}" data-toggle="tooltip"
						data-placement="bottom" title="Log-Out"> <i
							class="glyphicon glyphicon-log-out"></i>
					</a> <!-- csrt for log out-->
						<form action="${logoutUrl}" method="post" id="logoutForm">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form> <script>
							function formSubmit() {
								document.getElementById("logoutForm").submit();
							}
						</script></li>
				</sec:authorize>

				<!-- User is not logged in -->
				<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
					<li><a href="<c:url value="/client/signup" />"><i
							class="glyphicon glyphicon-user"></i> Sign Up </a></li>
					<li><a href="<c:url value="/login" />" data-toggle="tooltip"
						data-placement="bottom" title="Log-In"><i
							class="glyphicon glyphicon-log-in"></i></a></li>
				</sec:authorize>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>