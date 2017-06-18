/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import Utilitaires.Utilitaire;
import dao.Categorie;
import dao.Client;
import dao.ClientNetArticles;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Epulapp
 */
@WebServlet(name = "srvlClient", urlPatterns = {"/srvlClient"})
public class srvlCompte extends HttpServlet {

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
            if (demande.equalsIgnoreCase("login.cpt")) {
                vueReponse = "/login.jsp";
            } else if (demande.equalsIgnoreCase("connecter.cpt")) {
                vueReponse = connecter(request);
            } else if (demande.equalsIgnoreCase("deconnecter.cpt")) {
                vueReponse = deconnecter(request);
            } else if (demande.equalsIgnoreCase("voirCompte.cpt") || demande.equalsIgnoreCase("creerCompte.cpt")) {
                vueReponse = voirCompte(request);
            } else if (demande.equalsIgnoreCase("validerCompte.cpt")) {
                vueReponse = validerCompte(request);
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
    
    private String connecter(HttpServletRequest request) throws Exception {
        ClientNetArticles cna = new ClientNetArticles();
        Client reponse = cna.connecterClient(Client.class, request.getParameter("txtLogin"));
        String vueReponse;
        String sentMdp = request.getParameter("txtPwd");
        String receivedMdp = reponse.getPwdClient();
        if (receivedMdp == null ? sentMdp == null : reponse.getPwdClient().equals(sentMdp)) {
            //vueReponse = "/menu.jsp";
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", reponse.getIdClient());
            srvlNetArticle srvlArticle = new srvlNetArticle();
            vueReponse = srvlArticle.getLastArticle(request);
        } else {
            vueReponse = "/login.jsp";
            erreur = "Login ou mot de passe erronné !";
        }
        return vueReponse;
    }
    
    private String deconnecter(HttpServletRequest request) throws Exception {
        try {
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", null);
            return ("/menu.jsp");
        } catch (Exception e) {
            throw e;
        }
    } 
    
    private String voirCompte(HttpServletRequest request) throws Exception {
        ClientNetArticles cna = new ClientNetArticles();
        HttpSession session = request.getSession(true);
        Client cli;
        if (session.getAttribute("userId") != null)
        {
            cli = cna.getClient((int)session.getAttribute("userId"));
            
        } else {
            cli = new Client();
//            cli.setIdClient(0);
//            cli.setAdresseClient("");
//            Categorie cat = new Categorie();
//            cat.setIdCategorie(0);
//            cli.setCategorie(cat);
//            cli.setCredits(0);
//            cli.setIdentiteClient("");
//            cli.setLoginClient("");
//            cli.setPwdClient("");
        }
        request.setAttribute("clientR", cli);
        List<Categorie> lcat = cna.getCategories();
        request.setAttribute("listeCategoriesR", lcat);
        return "/client.jsp";
    }
    
    private String validerCompte(HttpServletRequest request) throws Exception {
        ClientNetArticles cna = new ClientNetArticles();
        Client cli;
        if (request.getParameter("id_client") != "")
        {
            cli = cna.getClient(Integer.parseInt(request.getParameter("id_client")));
        } else {
            cli = new Client();
            cli.setIdClient(0);
        }
        cli.setIdentiteClient(request.getParameter("txtIdentite"));
        cli.setAdresseClient(request.getParameter("txtAdresse"));
        cli.setLoginClient(request.getParameter("txtLogin"));
        cli.setPwdClient(request.getParameter("txtPwd"));
        cli.setCategorie(cna.getCategorie(Integer.parseInt(request.getParameter("cbCategories"))));
        cli.setCredits(Integer.parseInt(request.getParameter("txtCredits")));
        cna.editerCompte(cli);
        return "/menu.jsp";
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
