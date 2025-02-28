package com.megaCab.Services;

import com.megaCab.Database.dbConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Log received data (for debugging purposes)
        System.out.println("Received Login Data:");
        System.out.println("Username: " + username);

        // Validate input fields
        if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {

            System.out.println("❌ Missing or invalid login data!");
            response.sendRedirect("login.jsp?error=Please%20fill%20all%20fields.");
            return;
        }

        // Validate credentials in the database
        try (Connection conn = dbConnection.getConnection()) {
            if (conn == null) {
                System.out.println("❌ Database connection failed!");
                response.sendRedirect("login.jsp?error=Database%20connection%20failed.%20Please%20try%20again%20later.");
                return;
            }

            String sql = "SELECT id, password FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("password");

                // Verify password (plain-text for now; consider using BCrypt for hashing)
                if (password.equals(storedPassword)) {
                    System.out.println("✅ Login successful!");

                    // Create a session for the logged-in user
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", rs.getInt("id"));
                    session.setAttribute("username", username);

                    response.sendRedirect("dashboard.jsp");
                } else {
                    System.out.println("❌ Invalid password!");
                    response.sendRedirect("login.jsp?error=Invalid%20username%20or%20password.");
                }
            } else {
                System.out.println("❌ User not found!");
                response.sendRedirect("login.jsp?error=Invalid%20username%20or%20password.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=Database%20error.%20Please%20try%20again%20later.");
        }
    }
}