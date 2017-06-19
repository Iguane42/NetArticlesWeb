/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import Utilitaires.Utilitaire;
import dao.Achete;
import dao.AchetePK;
import dao.Article;
import dao.Auteur;
import dao.ClientBanque;
import dao.Domaine;
import dao.ClientNetArticles;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pkgProducteur.EmetteurTopic;

/**
 *
 * @author Epulapp
 */
@WebServlet(name = "srvlCommande", urlPatterns = {"/srvlCommande"})
public class srvlCommande extends HttpServlet {
    private String erreur;
    @EJB
    private EmetteurTopic emetteur;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String demande;
        String vueReponse = "/menu.jsp";
        erreur = "";
        try {
            demande = Utilitaire.getDemande(request);
            if (demande.equalsIgnoreCase("listeDomaines.cde")) {
                vueReponse = listeDomaine(request);
            } else if (demande.equalsIgnoreCase("listeArticlesDomaine.cde")) {
                vueReponse = listeDomaine(request);
            } else if (demande.equalsIgnoreCase("ajoutPanier.cde")) {
                vueReponse = ajouterPanier(request);
            } else if (demande.equalsIgnoreCase("supprimerPanier.cde")) {
                vueReponse = supprimerPanier(request);
            } else if (demande.equalsIgnoreCase("voirPanier.cde")) {
                vueReponse = listerPanier(request);
            } else if (demande.equalsIgnoreCase("validerPanier.cde")) {
                vueReponse = validerPanier(request);
            } else if (demande.equalsIgnoreCase("listeAchats.cde")) {
                vueReponse = getListeAchats(request);
            }
        } catch (Exception e) {
            erreur = e.getMessage();
        } finally {
            request.setAttribute("erreurR", erreur);
            request.setAttribute("pageR", vueReponse);
            RequestDispatcher dsp = request.getRequestDispatcher("/index.jsp");
            if (vueReponse.contains(".cpt")) {
                dsp = request.getRequestDispatcher(vueReponse);
            }
            dsp.forward(request, response);
        }
    }
    
    private String listeDomaine(HttpServletRequest request) throws Exception
    {
        ClientNetArticles cna = new ClientNetArticles();
        List<Domaine> lDomaine = cna.getDomaines();
        String vueReponse = "/rechercher.jsp";
        if (lDomaine.size() > 0) {
            request.setAttribute("lDomainesR", lDomaine);
        } else {
            erreur = "Aucun domaine n'a été trouvé.";
        }
        String Domaine = request.getParameter("id_domaine");
        if (Domaine == null) {
            Domaine = request.getParameter("cbDomaines");
        }
        if (Domaine != null){
            request.setAttribute("id_domaineR", Domaine);
            List<Article> lArticle = cna.getArticlesDomaine(Integer.parseInt(Domaine));
            request.setAttribute("lArticlesR", lArticle);
        }
        
        return vueReponse;
    }
    
    private String ajouterPanier(HttpServletRequest request) throws Exception
    {
        HttpSession session = request.getSession(true);
        Object panier = session.getAttribute("panier");
        List<Integer> lpanier;
        if (panier != null) {
            lpanier = (List<Integer>)panier;
        } else {
            lpanier = new ArrayList<Integer>();
        }
        String idArticle = request.getParameter("id_article");
        if (idArticle != null)
        {
            if (!lpanier.contains(Integer.parseInt(idArticle))) {
                lpanier.add(Integer.parseInt(idArticle));
                session.setAttribute("panier", lpanier);
            }
            
        } else {
            erreur = "Aucun article à ajouter au panier.";
        }
        return listerPanier(request);
    }
    
    private String supprimerPanier(HttpServletRequest request) throws Exception
    {
        HttpSession session = request.getSession(true);
        Object panier = session.getAttribute("panier");
        List<Integer> lpanier;
        if (panier != null) {
            lpanier = (List<Integer>)panier;
        } else {
            lpanier = new ArrayList<Integer>();
        }
        String idArticle = request.getParameter("id_article");
        if (idArticle != null)
        {
            if (lpanier.contains(Integer.parseInt(idArticle))) {
                lpanier.remove((Object)Integer.parseInt(idArticle));
                if (lpanier.size() == 0)
                {
                    lpanier = null;
                }
                session.setAttribute("panier", lpanier);
            }
            
        } else {
            erreur = "Aucun article à supprimer du panier.";
        }
        return listerPanier(request);
    }
    
    private String listerPanier(HttpServletRequest request) throws Exception
    {
        ClientNetArticles cna = new ClientNetArticles();
        HttpSession session = request.getSession(true);
        Object panier = session.getAttribute("panier");
        List<Integer> lpanier;
        double montantTotal = 0;
        if (panier != null) {
            lpanier = (List<Integer>)panier;
            List<Article>lArticle = new ArrayList<Article>();
            for(Integer idArticle: lpanier)
            {
                Article article = cna.getArticleId(Article.class, idArticle.toString());
                lArticle.add(article);
                montantTotal += article.getPrix().doubleValue();
            }
            request.setAttribute("lArticlesPanierR", lArticle);
            request.setAttribute("montantTotalR", montantTotal);
            request.setAttribute("titre", "Votre panier");
        } else {
            request.setAttribute("titre", "Panier vide");
        }
        return "panier.jsp";
    }
    
    private String validerPanier(HttpServletRequest request) throws Exception
    {
        ClientNetArticles cna = new ClientNetArticles();
        HttpSession session = request.getSession(true);
        Object idUser = session.getAttribute("userId");
        String vueReponse;
        if (idUser != null) {
            Object panier = session.getAttribute("panier");
            List<Integer> lpanier;
            double montantTotal = 0;
            if (panier != null) {
                lpanier = (List<Integer>)panier;
                List<Article>lArticle = new ArrayList<Article>();
                for(Integer idArticle: lpanier)
                {
                    Article article = cna.getArticleId(Article.class, idArticle.toString());
                    lArticle.add(article);
                    montantTotal += article.getPrix().doubleValue();
                }
                ClientBanque cb = new ClientBanque();
                Integer montantint = (int)Math.round(montantTotal);
                if (cb.autoriserPaiement(idUser.toString(),montantint.toString()))
                {
                    for(Article a : lArticle)
                    {
                        AchetePK apk = new AchetePK();
                        apk.setIdArticle(a.getIdArticle());
                        apk.setIdClient((Integer)idUser);
                        Achete ac = new Achete();
                        ac.setAchetePK(apk);
                        ac.setDateAchat(new Date());
                        cna.acheteArticle(ac);
                        List<Auteur> auteurs = cna.getAuteursArticle(a.getIdArticle());
                        for (Auteur auteur: auteurs)
                        {
                            emetteur.sendMessage(a.getTitre(), new Date(), auteur.getIdAuteur(), auteur.getIdentiteAuteur());
                        }
                    }
                    session.setAttribute("panier", null);
                    vueReponse = listerPanier(request);
                } else {
                    erreur = "Vous ne disposez pas de suffisament de crédits sur votre compte.";
                    vueReponse = listerPanier(request);
                }
            } else {
                erreur = "Votre panier est vide.";
                vueReponse = listerPanier(request);
            }
        } else {
            erreur = "Vous devez être connecté pour valider le panier.";
            vueReponse = "/login.jsp";
        }
        return vueReponse;
    }
    
    private String getListeAchats(HttpServletRequest request) throws Exception
    {
        ClientNetArticles cna = new ClientNetArticles();
        String vueReponse = "/listeAchats.jsp";
        HttpSession session = request.getSession(true);
        Object idUser = session.getAttribute("userId");
        List<Achete> achats = cna.getAchatsClient((Integer)idUser);
        request.setAttribute("lAchetesR", achats);
        return vueReponse;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
