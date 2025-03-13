package com.megaCab.Services;

import com.megaCab.JavaFiles.Vehicle;
import com.megaCab.dao.VehicleDAO;

import java.util.List;

public class VehicleService {
    private VehicleDAO vehicleDAO;

    public VehicleService() {
        vehicleDAO = new VehicleDAO();
    }

    // Add a new vehicle
    public boolean addVehicle(Vehicle vehicle) {
        return vehicleDAO.addVehicle(vehicle);
    }

    // Fetch all vehicles
    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.getAllVehicles();
    }
}