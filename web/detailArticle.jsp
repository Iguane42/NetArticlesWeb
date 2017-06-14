<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="well">
    <div class="row">
        <label class="col-md-2 text-right">N° Article : </label>
        <div class="col-md-6">${articleR.idArticle}</div>
    </div>
    <div class="row">
        <label class="col-md-2 text-right">Titre :</label>
        <div class="col-md-9">${articleR.titre}</div>
    </div>
    <div class="row">
        <label class="col-md-2 text-right">Résumé : </label>
        <div class="col-md-9">${articleR.resume}</div>
    </div>            
    <div class="row">
        <label class="col-md-2 text-right">Prix : </label>
        <div class="col-md-6"><fmt:formatNumber currencySymbol="&euro;" type="currency" value="${articleR.prix}"/></div>
    </div>  
    <div class="row">
        <label class="col-md-2 text-right">Date publication : </label>
        <div class="col-md-6"><fmt:formatDate pattern="dd/MM/yyyy" value="${articleR.dateArticle}"/></div>
    </div>  
    <div class="row">
        <label class="col-md-2 text-right">Domaine : </label>
        <div class="col-md-6">${articleR.domaine.libdomaine}</div>
    </div> 
</div>