package fit.cvut.si1.semestralka.tattooPro.web.DTO;

import fit.cvut.si1.semestralka.tattooPro.data.entities.Message;

/**
 * DTO for Message
 */
public class MessageDTO {
    private String sender;
    private String receiver;
    private String messageText;
    private String timeStamp;

    /**
     * Constructor with param.
     * @param message Message
     */
    public MessageDTO(Message message) {
        this.sender = message.getSender().getUsername();
        this.receiver = message.getReceiver().getUsername();
        this.messageText = message.getMessageText();
        this.timeStamp = message.getTimeStamp();
    }
    /**
     * Constructor with params.
     * @param sender Sender
     * @param receiver Receiver
     * @param messageText Message text
     * @param timeStamp time stamp of the message
     */
    public MessageDTO(String sender, String receiver, String messageText, String timeStamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.messageText = messageText;
        this.timeStamp = timeStamp;
    }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getReceiver() { return receiver; }
    public void setReceiver(String receiver) { this.receiver = receiver; }

    public String getMessageText() { return messageText; }
    public void setMessageText(String messageText) { this.messageText = messageText; }

    public String getTimeStamp() { return timeStamp; }

    public void setTimeStamp(String timeStamp) { this.timeStamp = timeStamp; }
}
