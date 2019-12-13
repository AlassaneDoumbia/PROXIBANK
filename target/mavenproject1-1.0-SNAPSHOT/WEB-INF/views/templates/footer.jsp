<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

	<hr>

<footer class="site-footer">
    <div class="text-center">
      <p>
        &copy; Copyrights <strong>Doumbia</strong>. Decembre 2019
      </p>
     
      <a href="index.html#" class="go-top">
        <i class="fa fa-angle-up"></i>
        </a>
    </div>
</footer>
<spring:url value="/resources/lib/jquery/jquery.min.js" var="jqueryJS" />
<script src="${jqueryJS}"></script>
<spring:url value="/resources/lib/jquery.dcjqaccordion.2.7.js" var="dcjqaccordion" />
<script class="include" type="text/javascript" src="${dcjqaccordion}"></script>
<spring:url value="/resources/lib/jquery.scrollTo.min.js" var="scrollTo" />
<script src="${scrollTo}"></script>
<spring:url value="/resources/lib/jquery.nicescroll.js" var="nicescroll" />
<script type="text/javascript" src="${nicescroll}"></script>
<spring:url value="/resources/lib/jquery.sparkline.js" var="sparkline" />
<script src="${sparkline}"></script>
<spring:url value="/resources/lib/common-scripts.js" var="commonScriptsJS" />
<script src="${commonScriptsJS}"></script>
<spring:url value="/resources/lib/gritter/js/jquery.gritter.js" var="gritterJS" />
<script type="text/javascript" src="${gritterJS}"></script>
<spring:url value="/resources/lib/gritter-conf.js" var="gritterConfJS" />
<script type="text/javascript" src="${gritterConfJS}"></script>
<spring:url value="/resources/lib/sparkline-chart.js" var="sparklineJS" />
<script src="${sparklineJS}"></script>
<spring:url value="/resources/lib/zabuto_calendar.js" var="zabutoCalendarJS" />
<script src="${zabutoCalendarJS}"></script>

<script type="text/javascript">
    
</script>
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



