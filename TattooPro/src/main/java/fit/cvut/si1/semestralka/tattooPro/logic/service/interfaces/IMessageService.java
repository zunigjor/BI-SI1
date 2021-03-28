package fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces;

import fit.cvut.si1.semestralka.tattooPro.data.entities.Message;

import java.util.List;

/**
 * Interface for image service class
 */
public interface IMessageService {

    /**
     * Adds a message to the database
     * @param message Message o be added
     * @return True on success.
     */
    public boolean add(Message message);

    /**
     * Lists all messages where sender is equal to the username from the param.
     * @param username Username
     * @return List of all messages where sender is equal to username param.
     */
    public List<Message> findBySender(String username);

    /**
     * Lists all messages where receiver is equal to the username from the param.
     * @param username Username
     * @return List of all messages where receiver is equal to username param.
     */
    public List<Message> findByReceiver(String username);
}
