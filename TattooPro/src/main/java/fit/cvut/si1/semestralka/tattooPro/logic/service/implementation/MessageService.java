package fit.cvut.si1.semestralka.tattooPro.logic.service.implementation;

import fit.cvut.si1.semestralka.tattooPro.data.DAO.interfaces.IMessageDAO;
import fit.cvut.si1.semestralka.tattooPro.data.entities.Message;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Message service class
 */
@Service
public class MessageService implements IMessageService {
    @Autowired
    private IMessageDAO messageDAO;

    /**
     * Adds a message to the database
     * @param message Message o be added
     * @return True on success.
     */
    @Override
    @Transactional
    public boolean add(Message message){

        message.setTimeStamp(java.util.Calendar.getInstance().getTime().toString());
        messageDAO.persist(message);
        return true;
    }
    /**
     * Lists all messages where sender is equal to the username from the param.
     * @param username Username
     * @return List of all messages where sender is equal to username param.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Message> findBySender(String username){
        return messageDAO.listBySender(username);
    }
    /**
     * Lists all messages where receiver is equal to the username from the param.
     * @param username Username
     * @return List of all messages where receiver is equal to username param.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Message> findByReceiver(String username){
        return messageDAO.listByReceiver(username);
    }
}