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
}
