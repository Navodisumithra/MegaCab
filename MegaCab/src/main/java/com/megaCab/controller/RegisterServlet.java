package com.megaCab.controller;

import com.megaCab.Database.DBConnection;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve and validate form data
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String nic = request.getParameter("nic");
        String telephone = request.getParameter("telephone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword"); // Fixed parameter name <button class="citation-flag" data-index="1">

        // Validation checks (omitted for brevity, same as original)
        // ... [keep your existing validation logic here] ...

        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "Database connection failed"); // <button class="citation-flag" data-index="6">
                return;
            }

            String sql = "INSERT INTO users (name, address, nic, telephone, username, password) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, address);
                pstmt.setString(3, nic);
                pstmt.setString(4, telephone);
                pstmt.setString(5, username);
                pstmt.setString(6, password); // Removed confirmPassword from insert <button class="citation-flag" data-index="2">

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    response.sendRedirect("register-success.jsp?message=Registration%20successful!");
                } else {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Registration failed"); // <button class="citation-flag" data-index="4">
                }
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                response.sendError(HttpServletResponse.SC_CONFLICT, "Username/NIC already exists"); // <button class="citation-flag" data-index="7">
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error"); // <button class="citation-flag" data-index="6">
            }
        }
    }
}