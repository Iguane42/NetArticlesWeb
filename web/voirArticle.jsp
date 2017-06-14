<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 align='center'>Dernier article paru</h1>
<c:import url="detailArticle.jsp"/>
<div class="col-md-6 col-md-offset-2">
    <a  class="btn btn-primary pull-left" href="ajoutPanier.cde?id_article=${articleR.idArticle}"><span class="glyphicon glyphicon-log-in"></span> Acquérir cet article</a>
    &nbsp;
    <c:if test="${id_domaineR != null}">
        <a class="btn btn-primary pull-right" href="listeDomaines.cde?id_domaine=${articleR.domaine.idDomaine}"><span class="glyphicon glyphicon-list"></span> Retour liste</a>
    </c:if>
</div>  



