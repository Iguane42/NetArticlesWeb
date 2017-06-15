/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgProducteur;

import java.util.Date;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.MapMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

/**
 *
 * @author Epulapp
 */
public class Emetteur {
    @Resource(mappedName = "FabriqueArticles")
    private static ConnectionFactory fabriqueArticles;
    @Resource(mappedName = "jms/Articles")
    private static Topic messagesArticles;
    private static TopicConnection connection = null;
    private static TopicSession session = null;
    private static TopicPublisher producteur = null;
    private static MapMessage mapMessage  = null;
    
    public void sendMessage(String titreArticle, Date date, int idAuteur, String identiteAuteur) throws Exception {
        try {
            connection = (TopicConnection) fabriqueArticles.createConnection();
            session = connection.createTopicSession(false, 0);
            producteur = session.createPublisher(messagesArticles);
            mapMessage = session.createMapMessage();
            mapMessage.setString("titre", titreArticle);
            mapMessage.setString("date", date.toString());
            mapMessage.setInt("id_auteur", idAuteur);
            mapMessage.setString("identite_auteur", identiteAuteur);
            //producteur.send(mapMessage);
            producteur.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    throw e;
                }
            }
        }
    }
}
