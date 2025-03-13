package com.megaCab.dao;

import com.megaCab.Database.DBConnection;
import com.megaCab.JavaFiles.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    private DBConnection dbConnection;

    public VehicleDAO() {
        this.dbConnection = new DBConnection();
    }

    // Add a new vehicle to the database
    public boolean addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (name, type, availability) VALUES (?, ?, ?)";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vehicle.getName());
            pstmt.setString(2, vehicle.getType());
            pstmt.setBoolean(3, vehicle.isAvailability());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Fetch all vehicles from the database
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";

        try (Connection conn = dbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id"));
                vehicle.setName(rs.getString("name"));
                vehicle.setType(rs.getString("type"));
                vehicle.setAvailability(rs.getBoolean("availability"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}