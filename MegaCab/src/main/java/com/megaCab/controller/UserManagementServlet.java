package com.megaCab.controller;

import com.megaCab.JavaFiles.User;
import com.megaCab.Services.AdminService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserManagementServlet extends HttpServlet {
    private AdminService adminService;

    public void init() {
        try {
            adminService = new AdminService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Check if admin is logged in
        if (session == null || !"Admin".equals(session.getAttribute("userType"))) {
            response.sendRedirect(request.getContextPath() + "/adminDashboard.jsp");
            return;
        }

        // Fetch all users
        List<User> users = adminService.getAllUsers();
        request.setAttribute("customers", users);
        // Forward to user management JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/manageUsers.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle user updates here
        String userId = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String nic = request.getParameter("nic");
        String telephone = request.getParameter("telephone");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User(userId, name, address, nic, telephone, null, password, null, email);
        boolean isUpdated = adminService.updateUserProfile(user);

        if (isUpdated) {
            response.sendRedirect(request.getContextPath() + "/admin/manageUsers.jsp?success=User updated successfully");
        } else {
            response.sendRedirect(request.getContextPath() + "/admin/manageUsers.jsp?error=Failed to update user");
        }
    }
}