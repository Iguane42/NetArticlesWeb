<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <td><fmt:formatNumber currencySymbol="&euro;" type="currency" value="${articleE.prix}"/></td>  
                <td><a href="voirArticle.na?id_article=${articleE.idArticle}">Résumé</a></td>                                     
                <td><a href="ajoutPanier.cde?id_article=${articleE.idArticle}">Panier</a></td>                       
            </tr>
        </c:forEach>
    </tbody>
</table>           

