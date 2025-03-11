package com.megaCab.controller;

import com.megaCab.JavaFiles.Booking;
import com.megaCab.Services.BookingService;
import com.megaCab.dao.BookingDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class BookingServlet extends HttpServlet {
    private BookingDAO bookingDAO;
    private BookingService bookingService = new BookingService();

    // Initialize the DAO in the servlet's init method
    public void init() {
        bookingDAO = new BookingDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve customer ID from session
        HttpSession session = request.getSession(false); // Avoid creating a new session unnecessarily
        if (session == null || session.getAttribute("customerId") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp"); // Redirect to login if not logged in
            return;
        }

        int customerId = (int) session.getAttribute("customerId");

        try {
            // Fetch bookings for the logged-in customer
            List<Booking> bookings = bookingDAO.getBookingsByUser(customerId);
            request.setAttribute("bookings", bookings);

            // Forward to the appropriate JSP page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/adminDashboard.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while fetching bookings.");
            request.getRequestDispatcher("/error.jsp").forward(request, response); // Handle errors gracefully
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data and create a new booking
        Booking booking = new Booking();
        boolean isBookingSuccessful = false;

        booking.setCustomerID(Integer.parseInt(request.getParameter("customerId")));
        booking.setPickupPoint(request.getParameter("pickupPoint"));
        booking.setDestination(request.getParameter("destination"));
        booking.setPickUpDate(request.getParameter("pickupDate"));
        booking.setCarType(request.getParameter("carType"));
        booking.setStatus(request.getParameter("status"));
        booking.setAmount(Double.parseDouble(request.getParameter("amount")));
        booking.setCouponCode(request.getParameter("couponCode"));

        isBookingSuccessful = bookingService.createNewBooking(booking);


        // Redirect based on booking success or failure
        if (isBookingSuccessful) {
            response.sendRedirect(request.getContextPath() + "/cabBookingSuccess.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/cabBookingFailed.jsp");
        }

        try {
            // Populate booking object with form data

        } catch (NumberFormatException | NullPointerException e) {
            // Handle invalid input or missing parameters
            request.setAttribute("errorMessage", "Invalid input. Please check the form fields.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while processing your request.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}