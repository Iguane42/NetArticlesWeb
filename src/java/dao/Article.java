/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Epulapp
 */
public class Article {

    /**
     * @return the idArticle
     */
    public Integer getIdArticle() {
        return idArticle;
    }

    /**
     * @param idArticle the idArticle to set
     */
    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the resume
     */
    public String getResume() {
        return resume;
    }

    /**
     * @param resume the resume to set
     */
    public void setResume(String resume) {
        this.resume = resume;
    }

    /**
     * @return the prix
     */
    public BigDecimal getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    /**
     * @return the dateArticle
     */
    public Date getDateArticle() {
        return dateArticle;
    }

    /**
     * @param dateArticle the dateArticle to set
     */
    public void setDateArticle(Date dateArticle) {
        this.dateArticle = dateArticle;
    }

    /**
     * @return the fichier
     */
    public String getFichier() {
        return fichier;
    }

    /**
     * @param fichier the fichier to set
     */
    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    /**
     * @return the redigeList
     */
    public List<Redige> getRedigeList() {
        return redigeList;
    }

    /**
     * @param redigeList the redigeList to set
     */
    public void setRedigeList(List<Redige> redigeList) {
        this.redigeList = redigeList;
    }

    /**
     * @return the acheteList
     */
    public List<Achete> getAcheteList() {
        return acheteList;
    }

    /**
     * @param acheteList the acheteList to set
     */
    public void setAcheteList(List<Achete> acheteList) {
        this.acheteList = acheteList;
    }

    /**
     * @return the domaine
     */
    public Domaine getDomaine() {
        return domaine;
    }

    /**
     * @param domaine the domaine to set
     */
    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }
    private Integer idArticle;
    private String titre;
    private String resume;
    private BigDecimal prix;
    private Date dateArticle;
    private String fichier;
    private List<Redige> redigeList;
    private List<Achete> acheteList;
    private Domaine domaine;
}
