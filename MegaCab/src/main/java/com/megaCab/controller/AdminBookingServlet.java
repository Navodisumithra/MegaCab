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
        bookingService = new BookingService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            // Default action: Fetch all bookings
            List<Booking> bookings = bookingService.getAllBookings();
            request.setAttribute("bookings", bookings);
            System.out.println(bookings.isEmpty());
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminBookingManage.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookingID = Integer.parseInt(request.getParameter("bookingID"));
        String status = request.getParameter("status");

        Booking updatedBooking = new Booking();
        updatedBooking.setBookingID(bookingID);
        updatedBooking.setStatus(status);

        boolean isUpdated = bookingService.updateBooking(updatedBooking);
        if (isUpdated) {
            response.sendRedirect(request.getContextPath() + "/admin/booking?action=list");
        } else {
            request.setAttribute("errorMessage", "Failed to update booking.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
