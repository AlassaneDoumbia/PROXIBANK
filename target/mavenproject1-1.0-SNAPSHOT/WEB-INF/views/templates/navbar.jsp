<%-- 
    Document   : navbar
    Created on : 10 déc. 2019, 09:19:38
    Author     : TOSHIBA
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
    <title>Proxibank</title>

    <spring:url value="/resources/lib/bootstrap/css/bootstrap.min.css" var="bootstrapMinCss" />
    <link href="${bootstrapMinCss}" rel="stylesheet" />
    <spring:url value="/resources/lib/font-awesome/css/font-awesome.css" var="fontAwesone" />
    <link href="${fontAwesone}" rel="stylesheet" />
    <spring:url value="/resources/css/zabuto_calendar.css" var="zabutoCalendarCss" />
    <link href="${zabutoCalendarCss}" rel="stylesheet" />
    <spring:url value="/resources/lib/gritter/css/jquery.gritter.css" var="gritterCss" />
    <link href="${gritterCss}" rel="stylesheet" />
    <spring:url value="/resources/css/style.css" var="styleCss" />
    <link href="${styleCss}" rel="stylesheet" />
    <spring:url value="/resources/css/style-responsive.css" var="responsiveCss" />
    <link href="${responsiveCss}" rel="stylesheet" />
    <spring:url value="/resources/lib/chart-master/Chart.js" var="chartJS" />
    <script src="${chartJS}"></script>
    <spring:url value="/resources/img/favicon.png" var="favicon" />
    <link href="${favicon}" rel="icon" />
    <spring:url value="/resources/img/apple-touch-icon.png" var="appleTouch" />
    <link href="${appleTouch}" rel="apple-touch-icon" />
</head>

<!--header start-->
<header class="header black-bg">
    <div class="sidebar-toggle-box">
      <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
    </div>
    <!--logo start-->
    <spring:url value="/" var="homeUrl" />
    <a href="${homeUrl}" class="logo"><b>PROXI<span>BANK</span></b></a>
    <!--logo end-->
    <div class="top-menu">
      <ul class="nav pull-right top-menu">
        <li><a class="logout" href="${homeUrl}">Logout</a></li>
      </ul>
    </div>
</header>
<!--header end-->

<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
            <spring:url value="/resources/img/ui-sam.jpg" var="ui" />
            <p class="centered"><a href="profile.html"><img src="${ui}" class="img-circle" width="80"></a></p>
            <h5 class="centered">Sam Soffes</h5>
            <li class="mt">
              <a class="active" href="${homeUrl}">
                <i class="fa fa-dashboard"></i>
                <span>Tableau de Bord</span>
                </a>
            </li>
            <li class="mt">
              <spring:url value="/operations" var="listeOperations" />
              <a href="${listeOperations}">
                <i class="fa fa-desktop"></i>
                <span>Operation</span>
                </a>
            </li>
            <li class="sub-menu">
              <a href="javascript:;">
                <i class="fa fa-users"></i>
                <span>Utilisateur</span>
                </a>
              <ul class="sub">
                <spring:url value="/clients" var="listeClients" />
                <spring:url value="/clients/add" var="ajoutClients" />
                <li><a href="${ajoutClients}">Ajouter un Utilisateur</a></li>
                <li><a href="${listeClients}">Liste des utilisateurs</a></li>
              </ul> 
            </li>
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->