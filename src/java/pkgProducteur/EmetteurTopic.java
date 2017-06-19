/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgProducteur;

import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.MapMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

/**
 *
 * @author Epulapp
 */
@Stateless
public class EmetteurTopic {

    @Resource(mappedName = "FabriqueArticles")
    public TopicConnectionFactory fabriqueArticles;
    
    @Resource(mappedName = "jms/Articles")
    public Topic messagesArticles;
    
    private TopicConnection connection = null;
    private TopicSession session = null;
    private TopicPublisher producteur = null;
    
    
    
    public void sendMessage(String titreArticle, Date date, int idAuteur, String identiteAuteur) throws Exception {
        try {
            connection = (TopicConnection) fabriqueArticles.createConnection();
            session = connection.createTopicSession(false, 0);
            producteur = session.createPublisher(messagesArticles);
            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("titre", titreArticle);
            mapMessage.setString("date", date.toString());
            mapMessage.setInt("id_auteur", idAuteur);
            mapMessage.setString("identite_auteur", identiteAuteur);
            producteur.send(mapMessage);
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
