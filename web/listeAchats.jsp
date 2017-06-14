<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1 align='center'>Liste de vos achats</h1>
<table class="table table-bordered table-striped">
    <thead>
        <tr>
            <td>Id</td>
            <td>Titre</td>
            <td>Domaine</td>
            <td>Date achat</td>                
            <td>Télécharger</td>                  
        </tr>
    </thead>
    <tbody>  
        <c:forEach var="achateE" items="${lAchetesR}">
            <tr>
                <td>${achateE.article.idArticle}</td>
                <td>${achateE.article.titre}</td>
                <td>${achateE.article.domaine.libdomaine}</td> 
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${achateE.dateAchat}" /></td>                     
                <td><a href="fichiers/${achateE.article.fichier}">Télécharger</a></td>                    
            </tr>
        </c:forEach>
    </tbody>
</table>  
