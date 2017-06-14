/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Epulapp
 */
public class Domaine {
    private Integer idDomaine;
    private String libdomaine;
    private List<Article> articleList;

    /**
     * @return the idDomaine
     */
    public Integer getIdDomaine() {
        return idDomaine;
    }

    /**
     * @param idDomaine the idDomaine to set
     */
    public void setIdDomaine(Integer idDomaine) {
        this.idDomaine = idDomaine;
    }

    /**
     * @return the libdomaine
     */
    public String getLibdomaine() {
        return libdomaine;
    }

    /**
     * @param libdomaine the libdomaine to set
     */
    public void setLibdomaine(String libdomaine) {
        this.libdomaine = libdomaine;
    }

    /**
     * @return the articleList
     */
    public List<Article> getArticleList() {
        return articleList;
    }

    /**
     * @param articleList the articleList to set
     */
    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
