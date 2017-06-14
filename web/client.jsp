<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <form class="form form-horizontal" role="form" action="validerCompte.cpt?id_client=${clientR.idClient}" method="post" name="frmModif">
        <h1 align='center'><c:out value="${titre}"/></h1>
        <div class="form-group">
            <label class="col-md-3 control-label">Identité : </label>
            <div class="col-md-3">
                <input type="text" name="txtIdentite" class="form-control" value="${clientR.identiteClient}" placeholder="Saisir votre identité" required autofocus>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Adresse : </label>
            <div class="col-md-6">
                <input type="text" name="txtAdresse"  class="form-control" value="${clientR.adresseClient}" placeholder="Saisir votre adresse" required>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Login : </label>
            <div class="col-md-3">
                <input type="text" name="txtLogin" class="form-control" value="${clientR.loginClient}" placeholder="Saisir votre identifiant" required>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Mot de passe : </label>
            <div class="col-md-3">
                <input type="text" name="txtPwd"  class="form-control" value="${clientR.pwdClient}" placeholder="Saisir votre mot de passe" required>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Crédits : </label>
            <div class="col-md-3">
                <input type="text" name="txtCredits" class="form-control" value="${clientR.credits}" placeholder="Saisir votre crédit" required>
            </div>
        </div>                                
        <div class="form-group">
            <label class="col-md-3 control-label">Catégorie : </label>
            <div class="col-md-3">
                <SELECT  class='form-control' name="cbCategories" required>
                    <option value="0" >Sélectionner une catégorie</option>
                    <c:forEach var="categorieE" items="${listeCategoriesR}">
                        <option value="${categorieE.idCategorie}"<c:if test="${categorieE.idCategorie == clientR.categorie.idCategorie}"> SELECTED</c:if> >${categorieE.libcategorie}</option>
                    </c:forEach>
                </SELECT>
            </div>
        </div>                  

        <div class="form-group">
            <div class="col-md-5 col-md-offset-3">
                <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-log-in"></span> Valider</button>
                &nbsp;
                <button type="button" class="btn btn-default btn-primary" value="Annuler" name="btnAnnuler" onClick="window.location.href = 'dernierArticle.na';"><span class="glyphicon glyphicon-remove"></span> Annuler</button>
            </div>
        </div> 
    </form>