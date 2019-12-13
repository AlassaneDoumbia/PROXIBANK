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
<spring:url value="/comptes/" var="listeCompteUrl" />

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
                        <button type="button" data-toggle="tooltip" data-placement="bottom"
                            title="Ajouter un client" onclick="location.href='${ajoutClientUrl}'" class="btn btn-theme02">
                            Ajouter un client
                        </button>
                        <button type="button" onclick="location.href='${ajoutClientUrl}'" data-toggle="tooltip" data-placement="bottom"
                              title="Ajouter un compte pour un client" class="btn btn-theme02">
                            Ajouter un compte pour un client
                        </button>
                    </div>
                </div>
                <div class="row mt col-lg-12 col-md-12 col-sm-12">
                    <div class="content-panel">
                        <div class="adv-table">

                            <h1>Liste des Clients</h1>
                            <table class="table table-striped display">
                                <thead>
                                    <tr>
                                        <th>Identifiant</th>
                                        <th>Nom</th>
                                        <th>Prénom</th>
                                        <th>Adresse</th>
                                        <th></th>
                                    </tr>
                                </thead>

                                <c:forEach var="client" items="${clients}">
                                    <tr>
                                        <td>${client.id}</td>
                                        <td>${client.nom}</td>
                                        <td>${client.prenom}</td>
                                        <td>${client.adresse}</td>
                                        <td>	
                                            <spring:url value="/comptes/${client.id}" var="compteUrl" />
                                        <spring:url value="/clients/${client.id}/delete" var="deleteUrl" />
                                        <spring:url value="/clients/${client.id}/update" var="updateUrl" />
                                        <div class="pull-right hidden-phone">
                                            <button class="btn btn-success btn-sm" onclick="location.href='${compteUrl}'" 
                                                data-toggle="tooltip" data-placement="bottom" title="Getions des comptes" >
                                                <i class=" fa fa-check"></i>
                                            </button>
                                            <button class="btn btn-primary btn-sm" onclick="location.href='${updateUrl}'" 
                                                data-toggle="tooltip" data-placement="bottom" title="Modifier utiliateur">
                                                <i class="fa fa-pencil"></i>
                                            </button>
                                            <button class="btn btn-danger btn-sm" onclick="location.href='${deleteUrl}'" 
                                                data-toggle="tooltip" data-placement="bottom" title="Supprimer utiliateur">
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