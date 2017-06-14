<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form form-horizontal" name="frmSearch" role="form" role="form" action="listeArticlesDomaine.cde" method="post">
    <h1 align='center'><c:out value="${titre}"/></h1>                               
    <div class="form-group">
        <label class="col-md-3 control-label">Domaine : </label>
        <div class="col-md-3">
            <SELECT  class='form-control' name="cbDomaines" id="cbDomaines" onChange="chargerListe();">
                <option value="0" >Sélectionner un domaine</option>
                <c:forEach var="domaineE" items="${lDomainesR}">
                    <option value="${domaineE.idDomaine}" <c:if test="${domaineE.idDomaine == id_domaineR}"> SELECTED</c:if> >${domaineE.libdomaine}</option>
                </c:forEach>
            </SELECT>
        </div>
    </div>                  
</form>      
<c:if test="${id_domaineR != null}">
<table class="table table-bordered table-striped">
    <thead>
        <tr>
            <td>Id</td>
            <td>Titre</td>
            <td>Prix</td>    
            <td>Résumé</td>   
            <td>Panier</td>                     
        </tr>
    </thead>
    <tbody>                            
        <c:forEach var="articleE" items="${lArticlesR}">
            <tr>
                <td>${articleE.idArticle}</td>
                <td>${articleE.titre}</td>
                <td>${articleE.prix}</td>                    
                <td><a href="voirArticle.na?id_article=${articleE.idArticle}">Résumé</a></td>                                     
                <td><a href="ajoutPanier.cde?id_article=${articleE.idArticle}">Panier</a></td>                       
            </tr>
        </c:forEach>
    </tbody>
</table>       
</c:if>