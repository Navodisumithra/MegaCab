package com.megaCab.Services;

import com.megaCab.JavaFiles.Booking;
import com.megaCab.dao.BookingDAO;
import com.megaCab.JavaFiles.Promotion;
import com.megaCab.dao.PromotionDAO;

import java.util.List;
import java.util.Optional;

public class BookingService {
    private PromotionDAO promotionDAO;
    private BookingDAO bookingDAO;

    public BookingService() {
        bookingDAO = new BookingDAO();
    }
//    public BookingService() {
//        promotionDAO = new PromotionDAO();
//    }

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

    public List<Booking> getAllBookingsByUser(String customerId) {
        return bookingDAO.getBookingsByUser(customerId);
    }

    public Booking getBookingByID(int bookingID) {
        return bookingDAO.getBookingByID(bookingID);
    }

    public boolean updateBookingStatus(int bookingID, String newStatus) {
        return bookingDAO.updateBookingStatus(bookingID, newStatus);
    }

    public double calculateTotalFare(Booking booking) {
//        double baseFare = booking.getBaseFare();
////        double distance = booking.getDistance();
//        double taxRate = booking.getTaxRate();
//
//        // Calculate fare based on distance
//        double distanceFare = baseFare * distance;
//
//        // Apply tax
//        double taxAmount = distanceFare * (taxRate / 100);
//
//        // Apply promotion discount
//        String promoCode = booking.getPromotionDiscount() > 0 ? "PROMO" : null;
//        Optional<Promotion> promotion = promotionDAO.getPromotionByCode(promoCode);
//        double discount = promotion.isPresent() ? 0 : 0;
//
//        double totalFare = distanceFare + taxAmount - (distanceFare * (discount / 100));
//        return totalFare;
        return 1000;
    }
}