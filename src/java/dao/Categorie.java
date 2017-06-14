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
class Categorie {
    private Integer idCategorie;
    private String libcategorie;
    //private List<Client> clientList;

    /**
     * @return the idCategorie
     */
    public Integer getIdCategorie() {
        return idCategorie;
    }

    /**
     * @param idCategorie the idCategorie to set
     */
    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    /**
     * @return the libcategorie
     */
    public String getLibcategorie() {
        return libcategorie;
    }

    /**
     * @param libcategorie the libcategorie to set
     */
    public void setLibcategorie(String libcategorie) {
        this.libcategorie = libcategorie;
    }
}
