package com.megaCab.controller;

import com.megaCab.Services.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/dashboard")
public class AdminDashboardServlet extends HttpServlet {
    private AdminService adminService;

    @Override
    public void init() {
        adminService = new AdminService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("admin") == null) {
            response.sendRedirect("../admin-login.jsp?error=Please%20login%20as%20admin.");
            return;
        }

        String action = request.getParameter("action");

        switch (action) {
            case "bookings":
                request.setAttribute("bookings", adminService.getAllBookings());
                request.getRequestDispatcher("/adminDashboard/manageBookings.jsp").forward(request, response);
                break;
            case "drivers":
//                request.setAttribute("drivers", adminService.getAllDrivers());
                request.getRequestDispatcher("/adminDashboard/manageDrivers.jsp").forward(request, response);
                break;
            case "users":
//                request.setAttribute("users", adminService.getAllUsers());
                request.getRequestDispatcher("/adminDashboard/manageUsers.jsp").forward(request, response);
                break;
            case "vehicles":
//                request.setAttribute("vehicles", adminService.getAllVehicles());
                request.getRequestDispatcher("/adminDashboard/manageVehicles.jsp").forward(request, response);
                break;
            case "promotions":
//                request.setAttribute("promotions", adminService.getAllPromotions());
                request.getRequestDispatcher("/adminDashboard/managePromotions.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/adminDashboard/adminDashboard.jsp").forward(request, response);
        }
    }
}