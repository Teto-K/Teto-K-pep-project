import Controller.SocialMediaController;
import DAO.AccountDAO;
import DAO.MessageDAO;
import io.javalin.Javalin;


import Model.Account;
import Model.Message;
import Service.AccountService;
import Service.MessageService;

/**
 * This class is provided with a main method to allow you to manually run and test your application. This class will not
 * affect your program in any way and you may write whatever code you like here.
 */
public class Main {
    public static void main(String[] args) {
        SocialMediaController controller = new SocialMediaController();
        Javalin app = controller.startAPI();
        app.start(8080);
        
        
        AccountDAO accD = new AccountDAO();
        Account account = new Account();
        account.username = "wowWhatATest";
        account.password = "tester";

        MessageDAO mesD = new MessageDAO();
        MessageService mesS = new MessageService();
        Message message = new Message();
        Message message2 = new Message();
        message.message_text = "hi hi hi hi hi hi hi hi";
        message.posted_by = 1;
        message.time_posted_epoch = 500;

        System.out.println("Message Created: " + mesD.createMessage(message));

        
        message2.message_text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        message2.posted_by = 1;
        message2.time_posted_epoch = 500;
        
        System.out.println("Message Updated: " + mesS.updateMessage(2, message2));
    }
}
