package com.megaCab.Services;

import com.megaCab.dao.BookingDao;
import com.megaCab.dao.DriverDao;
import com.megaCab.dao.AccountDao;
import com.megaCab.dao.VehicleDao;
import com.megaCab.dao.PramotionDao;

import java.util.List;

public class AdminService {
    private BookingDao bookingDAO;
    private DriverDao driverDAO;
    private AccountDao userDAO;
    private VehicleDao vehicleDAO;
    private PramotionDao promotionDAO;

    public AdminService() {
        this.bookingDAO = new BookingDao();
        this.driverDAO = new DriverDao();
        this.userDAO = new AccountDao();
        this.vehicleDAO = new VehicleDao();
        this.promotionDAO = new PramotionDao();
    }

    public List<Object> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

//    public List<Object> getAllDrivers() {
//        return driverDAO.getAllDrivers();
//    }

//    public List<Object> getAllUsers() {
//        return userDAO.getAllUsers();
//    }
//
//    public List<Object> getAllVehicles() {
//        return vehicleDAO.getAllVehicles();
//    }
//
//    public List<Object> getAllPromotions() {
//        return promotionDAO.getAllPromotions();
//    }
}