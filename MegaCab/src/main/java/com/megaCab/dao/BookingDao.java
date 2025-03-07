package com.megaCab.dao;

import com.megaCab.Database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDao {
    public List<Object> getAllBookings() {
        String sql = "SELECT id, user_id, car_name, status, booking_date FROM bookings";
        List<Object> bookings = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                bookings.add(new Object[] {
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("car_name"),
                        rs.getString("status"),
                        rs.getDate("booking_date")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }
}