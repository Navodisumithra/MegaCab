package com.megaCab.controller;

import com.megaCab.JavaFiles.Booking;
import com.megaCab.Services.BookingService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class AdminBookingServlet extends HttpServlet {
    private BookingService bookingService;

    public void init() {
        try {
            bookingService = new BookingService();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || "list".equals(action)) {
            // Default action: Fetch all bookings
            List<Booking> bookings = bookingService.getAllBookings();
            request.setAttribute("bookings", bookings);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/adminBookingManage.jsp");
            dispatcher.forward(request, response);

        } else if ("edit".equals(action)) {
            // Action: Edit a specific booking
            int bookingID = Integer.parseInt(request.getParameter("bookingID"));
            Booking booking = bookingService.getBookingByID(bookingID);

            if (booking != null) {
                request.setAttribute("booking", booking);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/editBookingForm.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/admin/booking?action=list&error=Booking not found");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("update".equals(action)) {
            // Action: Update a booking's details
            int bookingID = Integer.parseInt(request.getParameter("bookingID"));
            String pickupPoint = request.getParameter("pickupPoint");
            String destination = request.getParameter("destination");
            String pickupDate = request.getParameter("pickupDate");
            String carType = request.getParameter("carType");
            double amount = Double.parseDouble(request.getParameter("amount"));
            String status = request.getParameter("status");
            String couponCode = request.getParameter("couponCode");

            Booking updatedBooking = new Booking();
            updatedBooking.setBookingID(bookingID);
            updatedBooking.setPickupPoint(pickupPoint);
            updatedBooking.setDestination(destination);
            updatedBooking.setPickupDate(pickupDate);
            updatedBooking.setCarType(carType);
            updatedBooking.setAmount(amount);
            updatedBooking.setStatus(status);
            updatedBooking.setCouponCode(couponCode);

            boolean isUpdated = bookingService.updateBooking(updatedBooking);

            if (isUpdated) {
                response.sendRedirect(request.getContextPath() + "/admin/booking?action=list&success=Booking updated successfully");
            } else {
                response.sendRedirect(request.getContextPath() + "/admin/booking?action=list&error=Failed to update booking");
            }
        }
    }
}