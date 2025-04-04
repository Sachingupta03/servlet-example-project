package com.sachin.cab.booking.servlet.service;

import com.sachin.cab.booking.servlet.dao.DriverDAO;
import com.sachin.cab.booking.servlet.model.Driver;

import java.util.List;

public class DriverService {

    // Add a new driver
    public boolean registerDriver(Driver driver) {
        if (driver.getName() == null || driver.getLicenseNumber() == null) {
            throw new IllegalArgumentException("Driver details cannot be null.");
        }
        return DriverDAO.addDriver(driver);
    }

    // Get driver by ID
    public Driver getDriverById(int id) {
        return DriverDAO.getDriverById(id);
    }

    // Get all drivers
    public List<Driver> getAllDrivers() {
        return DriverDAO.getAllDrivers();
    }
}
