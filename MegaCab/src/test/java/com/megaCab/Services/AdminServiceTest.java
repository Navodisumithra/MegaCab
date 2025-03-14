package com.megaCab.Services;

import com.megaCab.JavaFiles.Booking;
import com.megaCab.JavaFiles.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class AdminServiceTest {

    private AdminService adminService = new AdminService();

    @Test
    void testGetAllBookings_ReturnsListOfBookings_WhenBookingsExist() {

        List<Booking> bookings = adminService.getAllBookings();
        assertNotNull(bookings);
    }

    @Test
    void testGetAllUsers_ReturnsListOfUsers_WhenUsersExist() {

        List<User> users = adminService.getAllUsers();
        assertNotNull(users);
    }
}