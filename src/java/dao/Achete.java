/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;

/**
 *
 * @author Epulapp
 */
public class Achete {
    private AchetePK achetePK;
    private Date dateAchat;
    private Article article;
    private Client client;

    /**
     * @return the achetePK
     */
    public AchetePK getAchetePK() {
        return achetePK;
    }

    /**
     * @param achetePK the achetePK to set
     */
    public void setAchetePK(AchetePK achetePK) {
        this.achetePK = achetePK;
    }

    /**
     * @return the dateAchat
     */
    public Date getDateAchat() {
        return dateAchat;
    }

    /**
     * @param dateAchat the dateAchat to set
     */
    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    /**
     * @return the article
     */
    public Article getArticle() {
        return article;
    }

    /**
     * @param article the article to set
     */
    public void setArticle(Article article) {
        this.article = article;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }
}
