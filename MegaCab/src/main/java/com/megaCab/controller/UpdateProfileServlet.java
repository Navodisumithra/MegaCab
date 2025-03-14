package com.megaCab.controller;

import com.megaCab.JavaFiles.User;
import com.megaCab.Services.AdminService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateProfileServlet extends HttpServlet {
    private AdminService adminService;

    public void init() {
        adminService = new AdminService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve updated data from the request
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String nic = request.getParameter("nic");
        String telephone = request.getParameter("telephone");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // Fetch the existing admin profile to retain the username and user_type
        HttpSession session = request.getSession();
        String adminUsername = (String) session.getAttribute("admin");
        User existingAdmin = adminService.getAdminProfile(adminUsername);

        if (existingAdmin == null) {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
            return;
        }

        // Update the admin's details
        User updatedAdmin = new User(
                id,
                name,
                address,
                nic,
                telephone,
                existingAdmin.getUsername(), // Keep username unchanged
                password,
                existingAdmin.getUserType(), // Keep user_type unchanged (e.g., "admin")
                email
        );

        boolean isUpdated = adminService.updateAdminProfile(updatedAdmin);

        if (isUpdated) {
            response.sendRedirect(request.getContextPath() + "/admin/profile?success=Profile updated successfully");
        } else {
            response.sendRedirect(request.getContextPath() + "/admin/profile?error=Failed to update profile");
        }
    }
}