package fit.cvut.si1.semestralka.tattooPro.data.DAO.interfaces;

import fit.cvut.si1.semestralka.tattooPro.data.entities.Message;

import java.util.List;

/**
 *Interface defining data layer interfaces for message management.
 */
public interface IMessageDAO{
    /**
     * Persists a message.
     * @param message Message to be saved.
     */
    void persist(Message message);
    /**
     * Updates a message.
     * @param message Message to be updated.
     */
    void update(Message message);
    /**
     * Removes a message.
     * @param message Message to be removed.
     */
    void remove(Message message);
    /**
     * Lists messages by sender.
     * @param username Owner of messages.
     * @return List of all messages where sender == username.
     */
    List listBySender(String username);
    /**
     * Lists messages by receiver.
     * @param username Owner of messages.
     * @return List of all messages where receiver == username.
     */
    List listByReceiver(String username);
}