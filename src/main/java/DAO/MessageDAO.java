package DAO;

import Model.Message;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {
    

    public Message createMessage(Message message) {
        Connection connection = ConnectionUtil.getConnection();



        return null;
    }

    public List<Message> getAllMessages(){
        Connection connection = ConnectionUtil.getConnection();

        List<Message> messages = new ArrayList<>();


        return messages;
    }

    public Message getAMessage(int id) {
        Connection connection = ConnectionUtil.getConnection();
        


        return null;
    }

    public void deleteMessage(int id) {
        Connection connection = ConnectionUtil.getConnection();




    }

    public void updateMessage(int id, Message message) {
        Connection connection = ConnectionUtil.getConnection();




    }

    
    public List<Message> getAllMessagesById(int accId){
        Connection connection = ConnectionUtil.getConnection();

        List<Message> messages = new ArrayList<>();


        return messages;
    }

}
