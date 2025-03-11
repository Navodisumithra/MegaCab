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

}
