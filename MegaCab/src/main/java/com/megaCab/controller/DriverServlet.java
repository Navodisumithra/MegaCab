package com.megaCab.controller;

import com.megaCab.JavaFiles.Driver;
import com.megaCab.Services.DriverService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/drivers")
public class DriverServlet extends HttpServlet {
    private DriverService driverService;

    @Override
    public void init() {
        driverService = new DriverService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch all drivers
        List<Driver> drivers = driverService.getAllDrivers();
        request.setAttribute("drivers", drivers);

        // Forward to the JSP page
        request.getRequestDispatcher("/drivers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        Driver driver = new Driver();
        driver.setName(request.getParameter("name"));
        driver.setPhone(request.getParameter("phone"));
        driver.setEmail(request.getParameter("email"));
        driver.setLicenseNumber(request.getParameter("licenseNumber"));
        driver.setAvailable(Boolean.parseBoolean(request.getParameter("isAvailable")));

        // Add the driver
        boolean isAdded = driverService.addDriver(driver);

        if (isAdded) {
            response.sendRedirect(request.getContextPath() + "/drivers?success=Driver added successfully.");
        } else {
            response.sendRedirect(request.getContextPath() + "/drivers?error=Failed to add driver.");
        }
    }
}