package com.megaCab.Services;

import com.megaCab.JavaFiles.Driver;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DriverServiceTest {
    private DriverService driverService = new  DriverService();

    @Test
    void testAddDriver_ReturnsTrue_WhenDriverIsAddedSuccessfully() {

        Driver driver = new Driver();
        driver.setEmail("driver@gmail.com");
        driver.setName("Driver 1");
        driver.setPhone("0123456799");
        driver.setLicenseNumber("bvc12345");
        driver.setAvailable(true);
        boolean result = driverService.addDriver(driver);

        assertTrue(result);
    }

    @Test
    void testAddDriver_ReturnsFalse_WhenDriverAdditionFails() {

        Driver emptyDriver = new Driver();
        boolean result = driverService.addDriver(emptyDriver);

        assertFalse(result);
    }


    @Test
    void testGetAllDrivers_ReturnsListOfDrivers_WhenDriversExist() {

        List<Driver> drivers = driverService.getAllDrivers();

        assertNotNull(drivers);
    }
}