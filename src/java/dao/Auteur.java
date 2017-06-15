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
public class Auteur {
    private Integer idAuteur;
    private String identiteAuteur;
    private String adresseAuteur;
    private String loginAuteur;
    private String pwdAuteur;
    private List<Redige> redigeList;
    private List<Droits> droitsList;

    /**
     * @return the idAuteur
     */
    public Integer getIdAuteur() {
        return idAuteur;
    }

    /**
     * @param idAuteur the idAuteur to set
     */
    public void setIdAuteur(Integer idAuteur) {
        this.idAuteur = idAuteur;
    }

    /**
     * @return the identiteAuteur
     */
    public String getIdentiteAuteur() {
        return identiteAuteur;
    }

    /**
     * @param identiteAuteur the identiteAuteur to set
     */
    public void setIdentiteAuteur(String identiteAuteur) {
        this.identiteAuteur = identiteAuteur;
    }

    /**
     * @return the adresseAuteur
     */
    public String getAdresseAuteur() {
        return adresseAuteur;
    }

    /**
     * @param adresseAuteur the adresseAuteur to set
     */
    public void setAdresseAuteur(String adresseAuteur) {
        this.adresseAuteur = adresseAuteur;
    }

    /**
     * @return the loginAuteur
     */
    public String getLoginAuteur() {
        return loginAuteur;
    }

    /**
     * @param loginAuteur the loginAuteur to set
     */
    public void setLoginAuteur(String loginAuteur) {
        this.loginAuteur = loginAuteur;
    }

    /**
     * @return the pwdAuteur
     */
    public String getPwdAuteur() {
        return pwdAuteur;
    }

    /**
     * @param pwdAuteur the pwdAuteur to set
     */
    public void setPwdAuteur(String pwdAuteur) {
        this.pwdAuteur = pwdAuteur;
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
     * @return the droitsList
     */
    public List<Droits> getDroitsList() {
        return droitsList;
    }

    /**
     * @param droitsList the droitsList to set
     */
    public void setDroitsList(List<Droits> droitsList) {
        this.droitsList = droitsList;
    }
}
