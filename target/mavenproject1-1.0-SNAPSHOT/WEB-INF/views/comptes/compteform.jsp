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
                            <h1>Enregistrer un compte client</h1>
                    </c:when>
                    <c:otherwise>
                            <h1>Modifier un compte client</h1>
                    </c:otherwise>
                </c:choose>
                <br />

                <spring:url value="/comptes/${id}" var="compteActionUrl" />

                <form:form class="form-horizontal" method="post" 
                        modelAttribute="compteForm" action="${compteActionUrl}">

                    <form:hidden path="id" />
                    
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
