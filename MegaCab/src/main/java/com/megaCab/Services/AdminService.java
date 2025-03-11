package com.megaCab.Services;

import com.megaCab.dao.BookingDAO;
import com.megaCab.dao.DriverDao;
import com.megaCab.dao.AccountDao;
import com.megaCab.dao.VehicleDao;
import com.megaCab.dao.PramotionDao;
import com.megaCab.JavaFiles.Booking; // Assuming Booking is a model class
//import com.megaCab.JavaFiles.Driver; // Assuming Driver is a model class
//import com.megaCab.JavaFiles.User; // Assuming User is a model class
//import com.megaCab.JavaFiles.Vehicle; // Assuming Vehicle is a model class
//import com.megaCab.JavaFiles.Promotion; // Assuming Promotion is a model class

import java.util.List;

public class AdminService {
    private BookingDAO bookingDAO;
    private DriverDao driverDAO;
    private AccountDao userDAO;
    private VehicleDao vehicleDAO;
    private PramotionDao promotionDAO;

    // Constructor to initialize DAOs
    public AdminService() {
        this.bookingDAO = new BookingDAO();
        this.driverDAO = new DriverDao();
        this.userDAO = new AccountDao();
        this.vehicleDAO = new VehicleDao();
        this.promotionDAO = new PramotionDao();
    }

    // Method to fetch all bookings
    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

//    // Method to fetch all drivers
//    public List<Driver> getAllDrivers() {
//        return driverDAO.getAllDrivers();
//    }
//
//    // Method to fetch all users
//    public List<User> getAllUsers() {
//        return userDAO.getAllUsers();
//    }
//
//    // Method to fetch all vehicles
//    public List<Vehicle> getAllVehicles() {
//        return vehicleDAO.getAllVehicles();
//    }
//
//    // Method to fetch all promotions
//    public List<Promotion> getAllPromotions() {
//        return promotionDAO.getAllPromotions();
//    }
}