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
    public List<Booking> getBookingsByUser(String customerId) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE customerID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, customerId);
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

    public boolean updateBookingStatus(int bookingID, String newStatus) {
        String sql = "UPDATE bookings SET status = ? WHERE bookingID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, newStatus);
            stmt.setInt(2, bookingID);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Creates a new booking in the database.
     *
     * @param booking The Booking object to be saved.
     * @return True if the booking was successfully created, false otherwise.
     */
    public boolean createBooking(Booking booking) {
        String query = "INSERT INTO bookings (customerID, pickupPoint, destination, pickupDate, carType, amount, status, couponCode, bookedDate, distance, baseFare) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, booking.getCustomerID());
            stmt.setString(2, booking.getPickupPoint());
            stmt.setString(3, booking.getDestination());
            stmt.setDate(4, booking.getPickupDate() != null ? new java.sql.Date(booking.getPickupDate().getTime()) : null);
            stmt.setString(5, booking.getCarType());
            stmt.setDouble(6, booking.getAmount());
            stmt.setString(7, booking.getStatus());
            stmt.setString(8, booking.getCouponCode());
            stmt.setDate(9, new java.sql.Date(new java.util.Date().getTime()));
            stmt.setDouble(10, booking.getDistance());
            stmt.setDouble(11, booking.getBaseFare());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
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
     * @return True if the booking was successfully updated, false otherwise.
     */
    public boolean updateBooking(Booking booking) {
        String query = "UPDATE bookings SET pickupPoint = ?, destination = ?, pickupDate = ?, carType = ?, amount = ?, status = ?, couponCode = ? WHERE bookingID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, booking.getPickupPoint());
            stmt.setString(2, booking.getDestination());
            stmt.setDate(3, booking.getPickupDate() != null ? new java.sql.Date(booking.getPickupDate().getTime()) : null);
            stmt.setString(4, booking.getCarType());
            stmt.setDouble(5, booking.getAmount());
            stmt.setString(6, booking.getStatus());
            stmt.setString(7, booking.getCouponCode());
            stmt.setInt(8, booking.getBookingID());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            handleSQLException(e, "Error updating booking with ID: " + booking.getBookingID());
        }
        return false;
    }

    /**
     * Deletes a booking from the database by its ID.
     *
     * @param bookingID The ID of the booking to delete.
     * @return
     */
    public boolean deleteBooking(int bookingID) {
        String query = "DELETE FROM bookings WHERE bookingID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, bookingID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            handleSQLException(e, "Error deleting booking with ID: " + bookingID);
        }
        return false;
    }

    /**
     * Fetches a single booking by its ID.
     *
     * @param bookingID The ID of the booking to fetch.
     * @return A Booking object if found, null otherwise.
     */
    public Booking getBookingByID(int bookingID) {
        String query = "SELECT * FROM bookings WHERE bookingID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bookingID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToBooking(resultSet);
            }
        } catch (SQLException e) {
            handleSQLException(e, "Error fetching booking with ID: " + bookingID);
        }
        return null;
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
 //       booking.setPickupDate(rs.getDate("pickupDate"));
        booking.setCarType(rs.getString("carType"));
        booking.setAmount(rs.getDouble("amount"));
        booking.setStatus(rs.getString("status"));
        booking.setCouponCode(rs.getString("couponCode"));
        booking.setBookedDate(rs.getDate("bookedDate"));
        booking.setBaseFare(rs.getDouble("baseFare"));
        booking.setDistance(rs.getDouble("distance"));

        return booking;
    }

    /**
     * Handles SQL exceptions by logging the error message and stack trace.
     *
     * @param e       The SQLException that occurred.
     * @param message A custom error message to log.
     */
    private void handleSQLException(SQLException e, String message) {
        // Replace with a proper logging framework like SLF4J or Log4j
        System.err.println(message);
        e.printStackTrace();
    }
}