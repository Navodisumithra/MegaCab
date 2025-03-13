package com.megaCab.dao;

import com.megaCab.Database.DBConnection;
import com.megaCab.JavaFiles.PaymentDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDao {

    public boolean makePayment(PaymentDetails paymentDetails) {
        String sql = "INSERT INTO payments(bookingID, totalAmount, paymentMethod, " +
                "paymentStatus, `paymentDate`) VALUES (?,?,?,?,now())";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, paymentDetails.getBookingID());
            stmt.setDouble(2, paymentDetails.getTotalAmount());
            stmt.setString(3, paymentDetails.getPaymentMethod());
            stmt.setString(4, "Paid");

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
