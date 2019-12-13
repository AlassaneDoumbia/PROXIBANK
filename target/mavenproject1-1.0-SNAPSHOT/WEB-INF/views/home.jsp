<%-- 
    Document   : liste
    Created on : 9 déc. 2019, 09:05:02
    Author     : TOSHIBA
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<spring:url value="/" var="homeUrl" />
<spring:url value="/clients/add" var="ajoutClientUrl" />
<spring:url value="/comptes/${client.id}/add" var="ajoutCompteUrl" />

<body>
    <section id="container">
        <jsp:include page="./templates/navbar.jsp"></jsp:include>
        <section id="main-content">
            <section class="wrapper">
                <div class="row mt">
                    <!-- WEATHER PANEL -->
                    <div class="col-md-4 mb">
                      <div class="weather pn">
                        <i class="fa fa-user fa-4x"></i>
                        <h2>${clients}</h2>
                        <h4>CLIENTS</h4>
                      </div>
                    </div>
                    <!-- /col-md-4-->
                    <div class="col-md-4 mb">
                      <div class="weather pn">
                        <i class="fa fa-cloud fa-4x"></i>
                        <h2>${operations}</h2>
                        <h4>OPERATIONS</h4>
                      </div>
                    </div>
                    <!-- /col-md-4-->
                    <div class="col-md-4 mb">
                        <div id="calendar" class="mb">
                            <div class="panel green-panel no-margin">
                                <div class="panel-body">
                                    <div id="date-popover" class="popover top" style="cursor: pointer; disadding: block; margin-left: 33%; margin-top: -50px; width: 175px;">
                                      <div class="arrow"></div>
                                      <h3 class="popover-title" style="disadding: none;"></h3>
                                      <div id="date-popover-content" class="popover-content"></div>
                                    </div>
                                    <div id="my-calendar"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /col-md-4-->
                </div>
            </section>
        </section>
    </section>

    <jsp:include page="./templates/footer.jsp" />
    
    <script type="application/javascript">
    $(document).ready(function() {
      $("#date-popover").popover({
        html: true,
        trigger: "manual"
      });
      $("#date-popover").hide();
      $("#date-popover").click(function(e) {
        $(this).hide();
      });

      $("#my-calendar").zabuto_calendar({
        action: function() {
          return myDateFunction(this.id, false);
        },
        action_nav: function() {
          return myNavFunction(this.id);
        },
        ajax: {
          url: "show_data.php?action=1",
          modal: true
        },
        legend: [{
            type: "text",
            label: "Special event",
            badge: "00"
          },
          {
            type: "block",
            label: "Regular event",
          }
        ]
      });
    });

    function myNavFunction(id) {
      $("#date-popover").hide();
      var nav = $("#" + id).data("navigation");
      var to = $("#" + id).data("to");
      console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
    }
  </script>
    
</body>