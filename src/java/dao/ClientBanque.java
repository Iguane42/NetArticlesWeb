/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Utilitaires.Utilitaire;
import javax.json.JsonObject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:WebServiceResource
 * [webservice]<br>
 * USAGE:
 * <pre>
 *        ClientBanque client = new ClientBanque();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Epulapp
 */
public class ClientBanque {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/BanqueRest/webresources";

    public ClientBanque() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("webservice");
    }

    public boolean autoriserPaiement(String id, String montant) throws ClientErrorException, Exception {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("autoriserPaiement/{0}/{1}", new Object[]{id, montant}));
        Response r = resource.request(MediaType.APPLICATION_JSON).get();
        if (r.getStatus() != Response.Status.OK.getStatusCode()){
            JsonObject jsonObject = Utilitaire.convertJson(r.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        } else {
            JsonObject jsonObject = Utilitaire.convertJson(r.readEntity(String.class));
            return jsonObject.getBoolean("Autorisation");
        }
    }

    public void close() {
        client.close();
    }
    
}
