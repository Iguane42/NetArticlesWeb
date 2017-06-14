<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="col-md-9 col-md-offset-2">
    <h1 align='center'><c:out value="${titre}"/></h1>
    <c:if test="${sessionScope.panier != null}">
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <td>Id</td>
                    <td>Titre</td>
                    <td>Prix</td>                  
                    <td>Supprimer</td>                     
                </tr>
            </thead>
            <tbody>                
                <c:forEach var="articleE" items="${lArticlesPanierR}">
                    <tr>
                        <td>${articleE.idArticle}</td>
                        <td>${articleE.titre}</td>
                        <td><fmt:formatNumber currencySymbol="&euro;" type="currency" value="${articleE.prix}"/></td>   
                        <td><a href="supprimerPanier.cde?id_article=${articleE.idArticle}">Supprimer</a></td>                         
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="2" style="text-align: right">Montant total</td>                    
                    <td><fmt:formatNumber currencySymbol="&euro;" type="currency" value="${montantTotalR}"/></td>                       
                </tr> 

            </tbody>
        </table>
        <div>
            <a class="btn btn-primary" href="validerPanier.cde"><span class="glyphicon glyphicon-log-in"></span> Valider panier</a>    
        </div>      
    </c:if>
</div>

