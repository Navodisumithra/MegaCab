package com.megaCab.Services;

import com.megaCab.JavaFiles.Booking;
import com.megaCab.dao.AccountDao;
import com.megaCab.JavaFiles.User;
import com.megaCab.dao.BookingDAO;

import java.sql.SQLException;
import java.util.List;

public class AdminService {
    private AccountDao userDAO = new AccountDao();
    private BookingDAO bookingDAO =  new BookingDAO();


    /**
     * Fetches the admin's profile by username.
     *
     * @param username The admin's username.
     * @return A User object representing the admin.
     */
    public User getAdminProfile(String username) {
        return userDAO.findUserByUsername(username);
    }

    /**
     * Updates the admin's profile in the database.
     *
     * @param admin The User object with updated details.
     * @return True if the update was successful, false otherwise.
     */
    public boolean updateAdminProfile(User admin) {
        return userDAO.updateUser(admin);
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public boolean updateUserProfile(User user) {
        return userDAO.updateUser(user);
    }

}