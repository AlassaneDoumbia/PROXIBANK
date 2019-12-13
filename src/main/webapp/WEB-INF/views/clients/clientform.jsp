<%-- 
    Document   : clientform
    Created on : 9 déc. 2019, 09:05:34
    Author     : TOSHIBA
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<body>
    <section id="container">
        <jsp:include page="../templates/navbar.jsp"></jsp:include>
        <section id="main-content">
            <section class="wrapper">
                <c:choose>
                    <c:when test="${clientForm['new']}">
                            <h1>Enregistrer un client</h1>
                    </c:when>
                    <c:otherwise>
                            <h1>Modifier un client</h1>
                    </c:otherwise>
                </c:choose>
                <br />

                <spring:url value="/clients" var="clientActionUrl" />

                <form:form class="form-horizontal" method="post" 
                        modelAttribute="clientForm" action="${clientActionUrl}">

                    <spring:bind path="nom">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">Nom</label>
                            <div class="col-sm-10">
                                    <form:input path="nom" type="text" class="form-control" id="nom"
                                            placeholder="Nom" />
                                    <form:errors path="nom" class="control-label" />
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="prenom">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">Prénom</label>
                            <div class="col-sm-10">
                                    <form:input path="prenom" type="text" class="form-control" id="prenom"
                                            placeholder="Prénom" />
                                    <form:errors path="prenom" class="control-label" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="adresse">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">Adresse</label>
                            <div class="col-sm-10">
                                <form:input path="adresse" type="text" class="form-control" id="adresse"
                                        placeholder="Adresse" />
                                <form:errors path="adresse" class="control-label" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="number">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">Numero</label>
                            <div class="col-sm-10">
                                <form:input path="number" type="number" class="form-control" id="number"
                                        placeholder="Numero de téléphone" />
                                <form:errors path="number" class="control-label" />
                            </div>
                        </div>
                    </spring:bind>
                     <spring:bind path="solde">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">Solde</label>
                            <div class="col-sm-10">
                                    <form:input path="solde" type="number" class="form-control" id="solde"
                                            placeholder="Solde" />
                                    <form:errors path="solde" class="control-label" />
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="type">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">Type de Compte</label>
                            <div class="col-sm-10">
                                <form:select path="type" id="type" class="form-control" >
                                    <form:options items="${types}" />
                                </form:select>
                            </div>
                        </div>
                    </spring:bind>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <c:choose>
                                <c:when test="${clientForm['new']}">
                                        <button type="submit" class="btn-lg btn-primary pull-right"   
                                            data-toggle="tooltip" data-placement="bottom" title="Enregistrer">
                                            Enregistrer
                                        </button>
                                </c:when>
                                <c:otherwise>
                                        <button type="submit" class="btn-lg btn-primary pull-right"   
                                            data-toggle="tooltip" data-placement="bottom" title="Mettre à jour">
                                            Mettre à jour
                                        </button>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </form:form>
            </section>
        </section>
    </section>

    <jsp:include page="../templates/footer.jsp" />

</body>
</html>
