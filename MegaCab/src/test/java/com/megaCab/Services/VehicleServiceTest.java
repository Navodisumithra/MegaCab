package com.megaCab.Services;

import com.megaCab.JavaFiles.Vehicle;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class VehicleServiceTest {
    private VehicleService vehicleService =  new VehicleService();

    @Test
    void testAddVehicle_ReturnsTrue_WhenVehicleIsAddedSuccessfully() {

        Vehicle vehicle = new Vehicle();
        vehicle.setName("van");
        vehicle.setType("toyota");
        vehicle.setAvailability(true);
        boolean result = vehicleService.addVehicle(vehicle);
        assertTrue(result);
    }

    @Test
    void testAddVehicle_ReturnsFalse_WhenVehicleAdditionFails() {

        Vehicle vehicle = new Vehicle();
        boolean result = vehicleService.addVehicle(vehicle);
        assertFalse(result);
    }

    @Test
    void testGetAllVehicles_ReturnsListOfVehicles_WhenVehiclesExist() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        assertNotNull(vehicles);
    }
}