package com.megaCab.Services;

import com.megaCab.JavaFiles.Booking;
import com.megaCab.dao.BookingDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

    public BookingService bookingService = new BookingService();
    public BookingDAO bookingDAO = new BookingDAO();

    @BeforeEach
    void setUp() {bookingService = new BookingService();}

    @Test
    void getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
    }

    @Test
    void createNewBooking() {
//        Booking booking = new Booking();
//        booking.getCustomerID();
//        booking.getPickupPoint();
//        booking.getDestination("Colombo");
//        booking.getPickupDate("2023.02.01");
//        booking.getCarType("Benze");
//        booking.getAmount(1);
//        booking.getStatus("pending");
//        booking.getCouponCode("CL2323");
//        booking.getDistance(25);
//        booking.getBaseFare(300);



//
//        boolean result = bookingService.createNewBooking(booking);
//        assertTrue(result, "booked");
    }

    @Test
    void updateBookingStatus() {
        boolean result = bookingService.updateBookingStatus(1, "pending");
        assertTrue(result, "booked");
    }

    @Test
    void calculateTotalFare() {
        // Arrange
        Booking booking = new Booking();
        booking.setBaseFare(100); // Base fare per km
        booking.setDistance(10); // Distance in km

        booking.setPromotionDiscount(0); // No promotion discount
        // Act
        double totalFare = bookingService.calculateTotalFare(booking);

        // Assert
        assertEquals(1000, totalFare, "The total fare should be 1000 (100 * 10 ).");
    }
}