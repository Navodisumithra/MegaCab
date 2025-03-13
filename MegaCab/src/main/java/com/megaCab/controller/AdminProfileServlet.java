package com.megaCab.controller;

import com.megaCab.JavaFiles.User;
import com.megaCab.dao.AccountDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/AdminProfileServlet")
public class AdminProfileServlet extends HttpServlet {
    private AccountDao accountDao;

    @Override
    public void init() throws ServletException {
        accountDao = new AccountDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            response.sendRedirect("login.jsp"); // Redirect to login if not logged in
            return;
        }

        User admin = accountDao.findUserByUsername(username);
        request.setAttribute("admin", admin);
        request.getRequestDispatcher("adminProfile.jsp").forward(request, response);
    }
}
