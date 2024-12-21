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

    public Message createMessage(Message message) {
        String txt = message.getMessage_text();
        if(txt != "" && txt != null && txt.length() <= 255) {
            return messageDAO.createMessage(message);
        } 
        return null;
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }
    
    public Message getAMessage(int id) {
        return messageDAO.getAMessage(id);
    }

    public Message deleteMessage(int id) {
        if(messageDAO.getAMessage(id) != null) {
            Message deletedMessage = messageDAO.getAMessage(id);
            messageDAO.deleteMessage(id);
            return deletedMessage;
        }
        return null;
    }

    public Message updateMessage(int id, Message message) {
        String txt = message.getMessage_text();
        if(messageDAO.getAMessage(id) != null && txt != "" && txt != null && txt.length() <= 255) {
            messageDAO.updateMessage(id, message);
            return messageDAO.getAMessage(id);
        } 
        return null;
    }

    public List<Message> getAllMessagesById(int accId) {
        return messageDAO.getAllMessagesById(accId);
    }
}
