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
        try{
            String sql = "INSERT INTO message(posted_by, message_text, time_posted_epoch) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, message.getPosted_by());
            ps.setString(2, message.getMessage_text());
            ps.setLong(3, message.getTime_posted_epoch());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                Message mes = new Message(rs.getInt("message_id"),
                        rs.getInt("posted_by"),
                        rs.getString("message_text"),
                        rs.getLong("time_posted_epoch"));
                return mes;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
