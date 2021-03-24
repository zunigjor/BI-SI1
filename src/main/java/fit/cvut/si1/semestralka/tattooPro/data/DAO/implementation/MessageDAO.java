package fit.cvut.si1.semestralka.tattooPro.data.DAO.implementation;

import fit.cvut.si1.semestralka.tattooPro.data.DAO.interfaces.IMessageDAO;
import fit.cvut.si1.semestralka.tattooPro.data.entities.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Message repository
 * !!!
 * Database constraints are programmers responsibility.
 * (Adding multiple things with the same id makes the database go boom)
 * !!!
 */
@Repository
public class MessageDAO implements IMessageDAO {
    @PersistenceContext
    private EntityManager em;
    /**
     * Persists a message.
     * @param message Message to be saved.
     */
    @Override
    public void persist(Message message) {
        em.persist(message);
    }
    /**
     * Updates a message.
     * @param message Message to be updated.
     */
    @Override
    public void update(Message message){
        em.merge(message);
    }
    /**
     * Removes a message.
     * @param message Message to be removed.
     */
    @Override
    public void remove(Message message){
        em.remove(message);
    }
    /**
     * Lists messages by sender.
     * @param username Owner of messages.
     * @return List of all messages where sender == username.
     */
    @Override
    public List listBySender(String username){
        return em.createQuery("SELECT m FROM Message m WHERE m.sender.username = :uid").setParameter("uid", username).getResultList();
    }
    /**
     * Lists messages by receiver.
     * @param username Owner of messages.
     * @return List of all messages where receiver == username.
     */
    @Override
    public List listByReceiver(String username){
        return em.createQuery("SELECT m FROM Message m WHERE m.receiver.username = :uid").setParameter("uid", username).getResultList();
    }
}