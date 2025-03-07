package com.megaCab.Services;

import com.megaCab.JavaFiles.User;
import com.megaCab.dao.AccountDao;

public class AccountService {

    private AccountDao accountDao;

    public AccountService() {
        this.accountDao = new AccountDao();
    }

    public User authenticateUser(String username, String password) throws IllegalArgumentException {
        // Validate input fields
        if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Please fill all fields.");
        }


        // Fetch user from the repository
        User user = accountDao.findUserByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("Invalid username or password.");
        }
//        System.err.println("entered: " + password + " database: " + user.get);
        // Verify password (plain-text for now; consider using BCrypt for hashing)
        if (!password.equals(user.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password.");
        }

        return user;
    }
}