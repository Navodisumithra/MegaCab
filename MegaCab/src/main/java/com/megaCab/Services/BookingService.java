package com.megaCab.Services;

import com.megaCab.JavaFiles.Booking;
import com.megaCab.dao.BookingDAO;

import java.util.List;

public class BookingService {

    private BookingDAO bookingDAO;

    public BookingService() {
        bookingDAO = new BookingDAO();
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    public boolean updateBooking(Booking booking) {
        return bookingDAO.updateBooking(booking);
    }

    public boolean createNewBooking(Booking booking) {
        return bookingDAO.createBooking(booking);
    }

    // Fix: Extract bookingID from the Booking object
    public boolean deleteBooking(Booking booking) {
        if (booking == null || booking.getBookingID() == 0) {
            throw new IllegalArgumentException("Invalid booking object or bookingID.");
        }
        int bookingID = booking.getBookingID(); // Get the bookingID from the Booking object
        return bookingDAO.deleteBooking(bookingID); // Pass the bookingID to the DAO
    }

    public Booking getBookingByID(int bookingID) {
        return bookingDAO.getBookingByID(bookingID);
    }
}