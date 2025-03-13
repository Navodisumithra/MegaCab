package com.megaCab.controller;

import com.megaCab.JavaFiles.User;
import com.megaCab.Services.BookingService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/user/dashboard")
public class CustomerDashboardServlet extends HttpServlet {
    private BookingService bookingService;

    @Override
    public void init() {
        // Initialize the BookingService
        bookingService = new BookingService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if the user is logged in
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("../login.jsp?error=Please%20login%20to%20access%20your%20dashboard.");
            return;
        }
        String userID = (String) session.getAttribute("userId");

        String action = request.getParameter("action");

        try {
            switch (action) {
                case "profile":
                    // Fetch user profile details using BookingService
//                    int userID = Integer.parseInt((String) session.getAttribute("user"));
                    //request.setAttribute("profile", bookingService.getUserProfile(userID));
                    request.getRequestDispatcher("/userDashboard/profile.jsp").forward(request, response);
                    break;

                case "bookings":
                    // Fetch all bookings for the user
                    List<?> bookings = bookingService.getAllBookingsByUser(userID);
                    request.setAttribute("bookings", bookings);
                    request.getRequestDispatcher("/viewBookings.jsp").forward(request, response);
                    break;

                case "payments":
                    // Fetch payment history for the user
//                    List<?> payments = bookingService.getPaymentsForUser(userID);
//                    request.setAttribute("payments", payments);
                    request.getRequestDispatcher("/userDashboard/payments.jsp").forward(request, response);
                    break;

                case "notifications":
                    // Fetch notifications for the user
//                    List<?> notifications = bookingService.getNotificationsForUser(userID);
//                    request.setAttribute("notifications", notifications);
                    request.getRequestDispatcher("/userDashboard/notifications.jsp").forward(request, response);
                    break;

                default:
                    // Default dashboard view
                    request.getRequestDispatcher("/userDashboard/dashboard.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while processing your request.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}