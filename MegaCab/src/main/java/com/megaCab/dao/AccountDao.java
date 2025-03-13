package com.megaCab.dao;

import com.megaCab.Database.DBConnection;
import com.megaCab.JavaFiles.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    private DBConnection dbConnection;

    public AccountDao() {
        this.dbConnection = new DBConnection();
    }

    /**
     * Fetches a user by username.
     *
     * @param username The username to search for.
     * @return A User object if found, null otherwise.
     */
    public User findUserByUsername(String username) {
        String sql = "SELECT id, name, address, nic, telephone, username, password, user_type, email FROM users WHERE username = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("nic"),
                        rs.getString("telephone"),
                        rs.getString("user_type"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
            throw new RuntimeException("Database error. Please try again later.");
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT id, name, address, nic, telephone, username, password, user_type, email FROM users " +
                "WHERE user_type = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,"Customer");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users.add(new User(
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("nic"),
                        rs.getString("telephone"),
                        rs.getString("user_type"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch users");
        }
        return users;
    }

    /**
     * Updates a user's details in the database.
     *
     * @param user The User object with updated data.
     * @return True if the update was successful, false otherwise.
     */
    public boolean updateUser(User user) {
        String sql = "UPDATE users SET name = ?, address = ?, nic = ?, telephone = ?, password = ?, user_type = ?, email = ? WHERE id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getAddress());
            pstmt.setString(3, user.getNic());
            pstmt.setString(4, user.getTelephone());
            pstmt.setString(5, user.getPassword());
            pstmt.setString(6, user.getUserType());
            pstmt.setString(7, user.getEmail());
            pstmt.setString(8, user.getId()); // Use 'id' as the primary key

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}