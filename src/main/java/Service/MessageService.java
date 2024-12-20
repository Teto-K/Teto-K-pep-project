package Service;

import Model.Message;
import DAO.MessageDAO;

import java.util.List;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService(){
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public Message createMessage(Message Message) {
        return messageDAO.createMessage(Message);
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }
    
    public Message getAMessage(int id) {
        return messageDAO.getAMessage(id);
    }

    public Message deleteMessage(int id) {
        return messageDAO.deleteMessage(id);
    }

    public Message updateMessage(int id, Message message) {
        if(messageDAO.getAllMessagesById(id) == null) {
            return null;
        } else {
            messageDAO.updateMessage(id, message);
            return messageDAO.getAMessage(id);
        }
    }

    public List<Message> getAllMessagesById(int accId) {
        return messageDAO.getAllMessagesById(accId);
    }
}
