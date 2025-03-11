package com.megaCab.dao;

import com.megaCab.Database.DBConnection;
import com.megaCab.JavaFiles.Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private Connection connection;

    // Constructor to initialize the database connection
    public BookingDAO() {
        connection = DBConnection.getConnection();
    }

    /**
     * Fetches all bookings for a specific user by their customer ID.
     *
     * @param customerId The ID of the customer.
     * @return A list of Booking objects.
     */
    public List<Booking> getBookingsByUser(int customerId) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM booking WHERE customerID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Booking booking = mapResultSetToBooking(rs);
                bookings.add(booking);
            }
        } catch (SQLException e) {
            handleSQLException(e, "Error fetching bookings for customer ID: " + customerId);
        }
        return bookings;
    }

    /**
     * Creates a new booking in the database.
     *
     * @param booking The Booking object to be saved.
     */
    public boolean createBooking(Booking booking) {
        String query = "INSERT INTO bookings (customerID, pickupPoint, destination, pickupDate, carType, amount, status, couponCode, bookedDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, booking.getCustomerID());
            stmt.setString(2, booking.getPickupPoint());
            stmt.setString(3, booking.getDestination());
            stmt.setString(4,booking.getPickUpDate());
            stmt.setString(5, booking.getCarType());
            stmt.setDouble(6, booking.getAmount());
            stmt.setString(7, booking.getStatus()); // Default status can be set in the service layer
            stmt.setString(8, booking.getCouponCode());
            stmt.setDate(9, new java.sql.Date(new java.util.Date().getTime()));

            int row = stmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            handleSQLException(e, "Error creating booking");
        }
        return false;
    }

    /**
     * Fetches all bookings from the database.
     *
     * @return A list of all Booking objects.
     */
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Booking booking = mapResultSetToBooking(rs);
                bookings.add(booking);
            }
        } catch (SQLException e) {
            handleSQLException(e, "Error fetching all bookings");
        }
        return bookings;
    }

    /**
     * Updates an existing booking in the database.
     *
     * @param booking The Booking object with updated details.
     */
    public boolean updateBooking(Booking booking) {
        String query = "UPDATE booking SET pickupPoint = ?, destination = ?, pickupDate = ?, carType = ?, amount = ?, status = ?, couponCode = ? WHERE bookingID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, booking.getPickupPoint());
            stmt.setString(2, booking.getDestination());
            stmt.setDate(3, new java.sql.Date(booking.getPickupDate().getTime()));
            stmt.setString(4, booking.getCarType());
            stmt.setDouble(5, booking.getAmount());
            stmt.setString(6, booking.getStatus());
            stmt.setString(7, booking.getCouponCode());
            stmt.setInt(8, booking.getBookingID());

            int row = stmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            handleSQLException(e, "Error updating booking with ID: " + booking.getBookingID());
        }
        return false;
    }

    /**
     * Deletes a booking from the database by its ID.
     *
     * @param bookingID The ID of the booking to delete.
     */
    public void deleteBooking(int bookingID) {
        String query = "DELETE FROM booking WHERE bookingID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, bookingID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            handleSQLException(e, "Error deleting booking with ID: " + bookingID);
        }
    }

    /**
     * Maps a ResultSet row to a Booking object.
     *
     * @param rs The ResultSet containing the data.
     * @return A Booking object.
     * @throws SQLException If there's an error accessing the ResultSet.
     */
    private Booking mapResultSetToBooking(ResultSet rs) throws SQLException {
        Booking booking = new Booking();
        booking.setBookingID(rs.getInt("bookingID"));
        booking.setCustomerID(rs.getInt("customerID"));
        booking.setPickupPoint(rs.getString("pickupPoint"));
        booking.setDestination(rs.getString("destination"));
        booking.setPickupDate(rs.getDate("pickupDate"));
        booking.setCarType(rs.getString("carType"));
        booking.setAmount(rs.getDouble("amount"));
        booking.setStatus(rs.getString("status"));
        booking.setCouponCode(rs.getString("couponCode"));
        booking.setBookedDate(rs.getDate("bookedDate"));
        return booking;
    }


    private void handleSQLException(SQLException e, String message) {
        // Replace with a proper logging framework like SLF4J or Log4j
        System.err.println(message);
        e.printStackTrace();
    }
}