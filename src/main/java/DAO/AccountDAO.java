package DAO;

import Model.Account;
import Util.ConnectionUtil;

import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {
    
    public Account createAccount(Account account) {
        Connection connection = ConnectionUtil.getConnection();
        try{
            String sql = "INSERT INTO account(username, password) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());

            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int generated_account_id = (int) rs.getLong(1);
                return new Account(generated_account_id, account.getUsername(), account.getPassword());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Account verifyLogin(Account account) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            String sql = "SELECT * FROM account WHERE account.username = ? AND account.password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Account acc = new Account(rs.getInt("account_id"),
                        rs.getString("username"),
                        rs.getString("password"));
                return acc;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
