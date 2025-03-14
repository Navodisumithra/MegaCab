package com.megaCab.dao;

import com.megaCab.Database.DBConnection;
import com.megaCab.JavaFiles.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO {
    private DBConnection dbConnection;

    public DriverDAO() {
        this.dbConnection = new DBConnection();
    }

    // Add a new driver to the database
    public boolean addDriver(Driver driver) {
        String sql = "INSERT INTO drivers (name, phone, email, licenseNumber, isAvailable, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, driver.getName());
            pstmt.setString(2, driver.getPhone());
            pstmt.setString(3, driver.getEmail());
            pstmt.setString(4, driver.getLicenseNumber());
            pstmt.setBoolean(5, driver.isAvailable());
            pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));

           int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Fetch all drivers from the database
    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        String sql = "SELECT * FROM drivers";

        try (Connection conn = dbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Driver driver = new Driver();
                driver.setDriverId(rs.getInt("driverId"));
                driver.setName(rs.getString("name"));
                driver.setPhone(rs.getString("phone"));
                driver.setEmail(rs.getString("email"));
                driver.setLicenseNumber(rs.getString("licenseNumber"));
                driver.setAvailable(rs.getBoolean("isAvailable"));
                driver.setCreatedAt(rs.getTimestamp("created_at"));
                drivers.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }
}