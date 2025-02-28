package com.megaCab.Services;

import com.megaCab.Database.dbConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String nic = request.getParameter("nic");
        String telephone = request.getParameter("telephone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Log received data (for debugging purposes)
        System.out.println("Received Data:");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("NIC: " + nic);
        System.out.println("Telephone: " + telephone);
        System.out.println("Username: " + username);

        // Validate input fields
        if (name == null || name.trim().isEmpty() ||
                address == null || address.trim().isEmpty() ||
                nic == null || nic.trim().isEmpty() ||
                telephone == null || telephone.trim().isEmpty() ||
                username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty() ||
                confirmPassword == null || confirmPassword.trim().isEmpty()) {

            System.out.println("❌ Missing or invalid form data!");
            response.sendRedirect("register-failed.jsp?error=Please%20fill%20all%20fields.");
            return;
        }

        // Validate NIC format (example: 9 digits followed by 'V' or 'v')
        if (!nic.matches("\\d{9}[Vv]")) {
            System.out.println("❌ Invalid NIC format!");
            response.sendRedirect("register-failed.jsp?error=Invalid%20NIC%20format.%20Example:%20123456789V");
            return;
        }

        // Validate telephone number format (example: 10 digits starting with '0')
        if (!telephone.matches("0\\d{9}")) {
            System.out.println("❌ Invalid telephone number format!");
            response.sendRedirect("register-failed.jsp?error=Invalid%20telephone%20number.%20Example:%200771234567");
            return;
        }

        // Validate password matching
        if (!password.equals(confirmPassword)) {
            System.out.println("❌ Passwords do not match!");
            response.sendRedirect("register-failed.jsp?error=Passwords%20do%20not%20match.");
            return;
        }

        // Insert data into the database
        try (Connection conn = dbConnection.getConnection()) {
            if (conn == null) {
                System.out.println("❌ Database connection failed!");
                response.sendRedirect("register-failed.jsp?error=Database%20connection%20failed.%20Please%20try%20again%20later.");
                return;
            }

            String sql = "INSERT INTO users (name, address, nic, telephone, username, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, nic);
            pstmt.setString(4, telephone);
            pstmt.setString(5, username);
            pstmt.setString(6, password); // Store the password (consider hashing it for security)

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ User registered successfully!");
                response.sendRedirect("register-success.jsp?message=Welcome%20" + name + "%20to%20Mega%20Cab!");
            } else {
                System.out.println("❌ Registration failed: Could not insert user.");
                response.sendRedirect("register-failed.jsp?error=Failed%20to%20register.%20Please%20try%20again.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
            e.printStackTrace();

            // Handle specific SQL exceptions (e.g., duplicate entry)
            if (e.getMessage().contains("Duplicate entry")) {
                response.sendRedirect("register-failed.jsp?error=Duplicate%20entry.%20Username%20or%20NIC%20already%20exists.");
            } else {
                response.sendRedirect("register-failed.jsp?error=Database%20error.%20Please%20try%20again%20later.");
            }
        }
    }
}