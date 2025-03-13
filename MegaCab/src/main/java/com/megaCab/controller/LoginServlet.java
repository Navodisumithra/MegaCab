package com.megaCab.controller;

import com.megaCab.JavaFiles.User;
import com.megaCab.Services.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;

public class LoginServlet extends HttpServlet {

    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.accountService = new AccountService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Log received data (for debugging purposes)
        System.out.println("Received Login Data:");
        System.out.println("Username: " + username);

        try {
            // Delegate login logic to the service layer
            User user = accountService.authenticateUser(username, password);

            // Create a session for the logged-in user
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("userType", user.getUserType());

            // Redirect based on user type
            String userType = user.getUserType();
            if ("Admin".equalsIgnoreCase(userType)) {
                response.sendRedirect("adminDashboard.jsp");
            } else if ("Driver".equalsIgnoreCase(userType)) {
                response.sendRedirect("driverDashboard.jsp");
            } else if ("Customer".equalsIgnoreCase(userType)) {
                response.sendRedirect("customerDashboard.jsp");
            } else {
                response.sendRedirect("login.jsp?error=Unknown%20user%20type.");
            }

        } catch (IllegalArgumentException e) {
            response.sendRedirect("login.jsp?error=" + URLEncoder.encode(e.getMessage(), "UTF-8"));
        } catch (Exception e) {
            System.out.println("❌ Unexpected error: " + e.getMessage());
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=An%20unexpected%20error%20occurred.%20Please%20try%20again%20later.");
        }
    }
}