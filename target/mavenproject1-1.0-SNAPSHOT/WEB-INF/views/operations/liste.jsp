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
                
                <div class="row mt col-lg-12 col-md-12 col-sm-12">
                    <div class="content-panel">
                        <div class="adv-table">

                            <h1>Liste des Operations</h1>
                            <table class="table table-striped display">
                                <thead>
                                    <tr>
                                        <th>Type</th>
                                        <th>Montant</th>
                                        <th>Nom Client</th>
                                        <th>Adresse Client</th>
                                        <th></th>
                                    </tr>
                                </thead>

                                <c:forEach var="operation" items="${operations}">
                                    <tr>
                                        <td>${operation.type}</td>
                                        <td>${operation.montant}</td>
                                        <td>${operation.client.nom}</td>
                                        <td>${operation.client.adresse}</td>
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
    
  
    
</body>