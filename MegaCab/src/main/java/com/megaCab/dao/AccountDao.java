package com.megaCab.dao;

import com.megaCab.Database.DBConnection;
import com.megaCab.JavaFiles.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {

    private DBConnection dbConnection;

    public AccountDao() {
        this.dbConnection = new DBConnection();
    }

    public User findUserByUsername(String username) {
        String sql = "SELECT id, name, address, nic, telephone, username, password, user_type FROM users WHERE username = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String userId = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String nic = rs.getString("nic");
                String telephone = rs.getString("telephone");
                String storedPassword = rs.getString("password");
                String userType = rs.getString("user_type");

                return new User(userId, name,storedPassword, userType);
            }
        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Database error. Please try again later.");
        }

        return null; // User not found
    }
}