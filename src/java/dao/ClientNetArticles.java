/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Utilitaires.Utilitaire;
import java.util.List;
import javax.json.JsonObject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:WebserviceResource
 * [webservice]<br>
 * USAGE:
 * <pre>
 *        ClientNetArticles client = new ClientNetArticles();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Epulapp
 */
public class ClientNetArticles {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/NetArticlesRest/webresources";

    public ClientNetArticles() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("webservice");
    }

    public List<Domaine> getDomaines() throws ClientErrorException, Exception {
        WebTarget resource = webTarget;
        resource = resource.path("getDomaines");
        Response r = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").get();
        if (r.getStatus() != Response.Status.OK.getStatusCode()){
            JsonObject jsonObject = Utilitaire.convertJson(r.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return r.readEntity(new GenericType<List<Domaine>>(){});
    }

    public <T> T getArticles(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getArticles");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").get(responseType);
    }

    public List<Article> getArticlesDomaine(Integer id_domaine) throws ClientErrorException, Exception {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getArticlesParDomaine/{0}", new Object[]{id_domaine}));
        Response r = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").get();
        if (r.getStatus() != Response.Status.OK.getStatusCode()){
            JsonObject jsonObject = Utilitaire.convertJson(r.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return r.readEntity(new GenericType<List<Article>>(){});
    }

    public <T> T connecterClient(Class<T> responseType, String login) throws ClientErrorException, Exception {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getConnexionClient/{0}", new Object[]{login}));
        Response r = resource.request(MediaType.APPLICATION_JSON + "; charset=UTF-8").get();
        if (r.getStatus() != Response.Status.OK.getStatusCode()){
            JsonObject jsonObject = Utilitaire.convertJson(r.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        T cli = r.readEntity(responseType);
        return cli;
    }
    
    public List<Achete> getAchatsClient(int id) throws ClientErrorException, Exception {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAchatsClient/{0}", new Object[]{id}));
        Response r = resource.request(MediaType.APPLICATION_JSON + "; charset=UTF-8").get();
        if (r.getStatus() != Response.Status.OK.getStatusCode()){
            JsonObject jsonObject = Utilitaire.convertJson(r.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        List<Achete> achats = r.readEntity(new GenericType<List<Achete>>(){});
        return achats;
    }

    public <T> T getArticleId(Class<T> responseType, String id_article) throws ClientErrorException, Exception {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getArticle/{0}", new Object[]{id_article}));
        Response r = resource.request(MediaType.APPLICATION_JSON + "; charset=UTF-8").get();
        if (r.getStatus() != Response.Status.OK.getStatusCode()){
            JsonObject jsonObject = Utilitaire.convertJson(r.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return r.readEntity(responseType);
    }
    
    public <T> T getLastArticle(Class<T> responseType) throws ClientErrorException, Exception {
        WebTarget resource = webTarget;
        resource = resource.path("getLastArticle");
        Response r = resource.request(MediaType.APPLICATION_JSON + "; charset=UTF-8").get();
        if (r.getStatus() != Response.Status.OK.getStatusCode()){
            JsonObject jsonObject = Utilitaire.convertJson(r.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return r.readEntity(responseType);
    }
    
    public void acheteArticle(Object requestEntity) throws ClientErrorException, Exception {
        WebTarget resource = webTarget;
        resource = resource.path("acheteArticle");
        Response r = resource.request(MediaType.APPLICATION_JSON + "; charset=UTF-8").post(javax.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_JSON + "; charset=UTF-8"), Response.class);
        if (r.getStatus() != Response.Status.OK.getStatusCode()){
            JsonObject jsonObject = Utilitaire.convertJson(r.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
    }
    
    public List<Auteur> getAuteursArticle(int id) throws ClientErrorException, Exception {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAuteursArticle/{0}", new Object[]{id}));
        Response r = resource.request(MediaType.APPLICATION_JSON + "; charset=UTF-8").get();
        if (r.getStatus() != Response.Status.OK.getStatusCode()){
            JsonObject jsonObject = Utilitaire.convertJson(r.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        List<Auteur> auteurs = r.readEntity(new GenericType<List<Auteur>>(){});
        return auteurs;
    }
    
    public void close() {
        client.close();
    }
    
}
