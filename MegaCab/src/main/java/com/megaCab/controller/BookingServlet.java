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

        String customerId = (String) session.getAttribute("customerId");

        try {
            // Fetch bookings for the logged-in customer
            List<Booking> bookings = bookingDAO.getBookingsByUser(customerId);
            request.setAttribute("bookings", bookings);
            System.out.println(bookings);

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
        String action = request.getParameter("action");
        System.out.println("action: " + action);

        if ("updateStatus".equals(action)) {
            int bookingID = Integer.parseInt(request.getParameter("bookingID"));
            String newStatus = request.getParameter("status");

            boolean isUpdated = bookingService.updateBookingStatus(bookingID, newStatus);

            if (isUpdated) {
                response.sendRedirect(request.getContextPath() + "/admin_booking");
            } else {
                response.sendRedirect(request.getContextPath() + "/admin_booking");
            }
        } else {
            Booking booking = new Booking();
            boolean isBookingSuccessful = false;

            double totalFare = bookingService.calculateTotalFare(booking);
            request.setAttribute("totalFare", totalFare);
            request.setAttribute("booking", booking);

            booking.setCustomerID(Integer.parseInt(request.getParameter("customerId")));
            booking.setPickupPoint(request.getParameter("pickupPoint"));
            booking.setDestination(request.getParameter("destination"));
            booking.setPickupDate(request.getParameter("pickupDate"));
            booking.setCarType(request.getParameter("carType"));
            booking.setStatus("PENDING");
            booking.setAmount(Double.parseDouble(request.getParameter("amount")));
            booking.setCouponCode(request.getParameter("couponCode"));
            booking.setDistance(Double.parseDouble(request.getParameter("distance")));

            double baseFare = calculateBaseFare(booking.getCarType(), booking.getDistance());
            booking.setBaseFare(baseFare);

            isBookingSuccessful = bookingService.createNewBooking(booking);

            if (isBookingSuccessful) {
                response.sendRedirect(request.getContextPath() + "/cabBookingSuccess.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/cabBookingFailed.jsp");
            }
        }
    }
    private double calculateBaseFare(String carType, double distance) {
        // Define base rates for different car types (per kilometer)
        double sedanRate = 10.0; // $10 per km for Sedan
        double suvRate = 15.0;   // $15 per km for SUV
        double vanRate = 20.0;   // $20 per km for Van

        // Determine the rate based on the car type
        double ratePerKm;
        switch (carType.toUpperCase()) {
            case "SEDAN":
                ratePerKm = sedanRate;
                break;
            case "SUV":
                ratePerKm = suvRate;
                break;
            case "VAN":
                ratePerKm = vanRate;
                break;
            default:
                throw new IllegalArgumentException("Invalid car type: " + carType);
        }

        // Calculate base fare as rate per km multiplied by distance
        return ratePerKm * distance;
    }

}