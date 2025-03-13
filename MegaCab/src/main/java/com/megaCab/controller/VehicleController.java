package com.megaCab.controller;

import com.megaCab.JavaFiles.Vehicle;
import com.megaCab.Services.VehicleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/vehicles")
public class VehicleController extends HttpServlet {
    private VehicleService vehicleService;

    @Override
    public void init() {
        vehicleService = new VehicleService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch all vehicles
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        request.setAttribute("vehicles", vehicles);

        // Forward to the JSP page
        request.getRequestDispatcher("/vehicles.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        Vehicle vehicle = new Vehicle();
        vehicle.setName(request.getParameter("name"));
        vehicle.setType(request.getParameter("type"));
        vehicle.setAvailability(Boolean.parseBoolean(request.getParameter("availability")));

        // Add the vehicle
        boolean isAdded = vehicleService.addVehicle(vehicle);

        if (isAdded) {
            response.sendRedirect(request.getContextPath() + "/vehicles?success=Vehicle added successfully.");
        } else {
            response.sendRedirect(request.getContextPath() + "/vehicles?error=Failed to add vehicle.");
        }
    }
}