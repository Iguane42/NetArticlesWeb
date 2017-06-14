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
public class Client {
    private Integer idClient;
    private String identiteClient;
    private String adresseClient;
    private Integer credits;
    private String loginClient;
    private String pwdClient;
    //private List<Achete> acheteList;
    private Categorie categorie;

    /**
     * @return the idClient
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     * @return the identiteClient
     */
    public String getIdentiteClient() {
        return identiteClient;
    }

    /**
     * @return the adresseClient
     */
    public String getAdresseClient() {
        return adresseClient;
    }

    /**
     * @return the credits
     */
    public Integer getCredits() {
        return credits;
    }

    /**
     * @return the loginClient
     */
    public String getLoginClient() {
        return loginClient;
    }

    /**
     * @return the pwdClient
     */
    public String getPwdClient() {
        return pwdClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     * @param identiteClient the identiteClient to set
     */
    public void setIdentiteClient(String identiteClient) {
        this.identiteClient = identiteClient;
    }

    /**
     * @param adresseClient the adresseClient to set
     */
    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    /**
     * @param credits the credits to set
     */
    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    /**
     * @param loginClient the loginClient to set
     */
    public void setLoginClient(String loginClient) {
        this.loginClient = loginClient;
    }

    /**
     * @param pwdClient the pwdClient to set
     */
    public void setPwdClient(String pwdClient) {
        this.pwdClient = pwdClient;
    }

    /**
     * @return the categorie
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
}
