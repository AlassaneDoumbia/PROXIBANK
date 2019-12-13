<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>Proxibank</title>

<spring:url value="/resources/style.css" var="costumCss" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${costumCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="homeUrl" />
<spring:url value="/clients/add" var="ajoutClientUrl" />
<spring:url value="/comptes/" var="listeCompteUrl" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${homeUrl}">SCHOOL SPACE</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active">
				<a href="${ajoutClientUrl}">
					Ajouter Client
					<span class="badge">
						<span class="glyphicon glyphicon-plus"></span>
					</span>
				</a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="">
					<a href="${listeCompteUrl}">
						Liste Ecole
						<span class="badge">
							<span class="glyphicon glyphicon-plus"></span>
						</span>
					</a>
				</li>
			</ul>
		</div>
	</div>
</nav>