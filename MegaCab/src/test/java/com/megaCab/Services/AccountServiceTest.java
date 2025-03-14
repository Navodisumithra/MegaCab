package com.megaCab.Services;

import com.megaCab.JavaFiles.User;
import com.megaCab.dao.AccountDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class AccountServiceTest {

    private AccountService accountService = new AccountService();


    @Test
    void testAuthenticateUser_ThrowsException_WhenUsernameIsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.authenticateUser("", "password123");
        });
        assertEquals("Please fill all fields.", exception.getMessage());
    }

    @Test
    void testAuthenticateUser_ThrowsException_WhenPasswordIsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.authenticateUser("john_doe", "");
        });
        assertEquals("Please fill all fields.", exception.getMessage());
    }

    @Test
    void testAuthenticateUser_ThrowsException_WhenUsernameIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.authenticateUser(null, "password123");
        });
        assertEquals("Please fill all fields.", exception.getMessage());
    }

    @Test
    void testAuthenticateUser_ThrowsException_WhenPasswordIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.authenticateUser("john_doe", null);
        });
        assertEquals("Please fill all fields.", exception.getMessage());
    }

    @Test
    void testAuthenticateUser_ThrowsException_WhenUserDoesNotExist() {


        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.authenticateUser("unknown_user", "password123");
        });
        assertEquals("Invalid username or password.", exception.getMessage());
    }

    @Test
    void testAuthenticateUser_ThrowsException_WhenPasswordIsIncorrect() {
        // Configure the stub to return a user with a specific password
        User mockUser = new User();
        mockUser.setUsername("john_doe");
        mockUser.setPassword("correct_password");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.authenticateUser("john_doe", "wrong_password");
        });
        assertEquals("Invalid username or password.", exception.getMessage());
    }

}