package com.megaCab.Services;

import com.megaCab.JavaFiles.Driver;
import com.megaCab.dao.DriverDAO;

import java.util.List;

public class DriverService {
    private DriverDAO driverDAO;

    public DriverService() {
        driverDAO = new DriverDAO();
    }

    // Add a new driver
    public boolean addDriver(Driver driver) {
        return driverDAO.addDriver(driver);
    }

    // Fetch all drivers
    public List<Driver> getAllDrivers() {
        return driverDAO.getAllDrivers();
    }
}