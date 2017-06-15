/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import Utilitaires.Utilitaire;
import dao.Article;
import dao.ClientNetArticles;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Epulapp
 */
@WebServlet(name = "srvlNetArticle", urlPatterns = {"/srvlNetArticle"})
public class srvlNetArticle extends HttpServlet {
    private String erreur;
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
            if (demande.equalsIgnoreCase("dernierArticle.na")) {
                vueReponse = getLastArticle(request);
            } else if (demande.equalsIgnoreCase("voirArticle.na")) {
                vueReponse = getArticleId(request);
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
    
    public String getLastArticle(HttpServletRequest request) throws Exception {
        ClientNetArticles cna = new ClientNetArticles();
        Article reponse = cna.getLastArticle(Article.class);
        String vueReponse = "/voirArticle.jsp";
        if (reponse.getIdArticle() != null) {
            request.setAttribute("articleR", reponse);
            //request.setAttribute("id_domaineR", reponse.getDomaine().getIdDomaine());
        } else {
            erreur = "Aucun dernier article n'a été trouvé.";
        }
        return vueReponse;
    }
    
    public String getArticleId(HttpServletRequest request) throws Exception 
    {
        ClientNetArticles cna = new ClientNetArticles();
        Article reponse = cna.getArticleId(Article.class, request.getParameter("id_article"));
        String vueReponse = "/voirArticle.jsp";
        if (reponse.getIdArticle() != null) {
            request.setAttribute("articleR", reponse);
            request.setAttribute("id_domaineR", reponse.getDomaine().getIdDomaine());
        } else {
            erreur = "Aucun dernier article n'a été trouvé.";
        }
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
