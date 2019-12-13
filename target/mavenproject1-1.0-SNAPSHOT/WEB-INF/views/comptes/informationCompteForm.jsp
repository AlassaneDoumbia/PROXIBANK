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
        <jsp:include page="../templates/navbar.jsp"></jsp:include>
        <section id="main-content">
            <section class="wrapper">
                <!--  THEME BUTTONS -->
                <div class="row mt col-lg-6 col-md-6 col-sm-12">
                    <div class="showback">
                      <h4><i class="fa fa-angle-right"></i> Effectuer un ajout</h4>
                      <!-- Standard button -->
                      <button type="button" onclick="location.href='${ajoutCompteUrl}'" class="btn btn-theme02">Ajouter un autre compte</button>
                    </div>
                </div>
                <div class="row mt col-lg-12 col-md-12 col-sm-12">
                    <div class="content-panel">
                        <div class="adv-table">

                            <h1>Comptes : ${client.nom} ${client.prenom}</h1>
                            <table class="table table-striped display">
                                <thead>
                                    <tr>
                                        <th>Type</th>
                                        <th>Solde</th>
                                        <th></th>
                                    </tr>
                                </thead>

                                <c:forEach var="compte" items="${comptes}">
                                    <tr>
                                        <td>${compte.type}</td>
                                        <td>${compte.solde}</td>
                                        <td>					
                                        <spring:url value="/comptes/${client.id}/delete/${compte.id}" var="deleteUrl" />
                                        <spring:url value="/comptes/${client.id}/update/${compte.id}" var="updateUrl" />
                                        <spring:url value="/comptes/${client.id}/debiter/${compte.id}" var="debiterUrl" />
                                        <spring:url value="/comptes/${client.id}/crediter/${compte.id}" var="crediterUrl" />
                                        <div class="pull-right hidden-phone">
                                            <button class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="bottom"
                                                    title="Crediter" onclick="location.href='${crediterUrl}'">
                                                <i class="fa fa-minus"></i>
                                            </button>
                                            <button class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="bottom"
                                                    title="Debiter" onclick="location.href='${debiterUrl}'">
                                                <i class="fa fa-plus"></i>
                                            </button>
                                            <button class="btn btn-primary btn-sm"  data-toggle="tooltip" data-placement="bottom"
                                                    title="Mise à jour" onclick="location.href='${updateUrl}'">
                                                <i class="fa fa-pencil"></i>
                                            </button>
                                            <button class="btn btn-danger btn-sm" data-toggle="tooltip" data-placement="bottom"
                                                    title="Delete" onclick="location.href='${deleteUrl}'">
                                                <i class="fa fa-trash-o "></i>
                                            </button>
                                         </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
             
            </section>
        </section>
    </section>

    <jsp:include page="../templates/footer.jsp" />
    
    <script type="text/javascript">
        if(${msg}){
           var unique_id = $.gritter.add({
            // (string | mandatory) the heading of the notification
            title: 'Notification!',
            // (string | mandatory) the text inside the notification
            text: ${msg},
            // (string | optional) the image to display on the left
            image: 'templates/img/ui-sam.jpg',
            // (bool | optional) if you want it to fade out on its own or just sit there
            sticky: false,
            // (int | optional) the time you want it to be alive for before fading out
            time: 8000,
            // (string | optional) the class name you want to apply to that specific message
            class_name: 'my-sticky-class'
          }); 
        }
   
</script>
    
</body>