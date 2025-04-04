package com.sachin.cab.booking.servlet.dao;

import com.sachin.cab.booking.servlet.model.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO {

    // Insert new driver
    public static boolean addDriver(Driver driver) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO driver (name, license_number, phone_number, car_model, is_available) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, driver.getName());
            ps.setString(2, driver.getLicenseNumber());
            ps.setString(3, driver.getPhoneNumber());
            ps.setString(4, driver.getCarModel());
            ps.setBoolean(5, driver.isAvailable());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get driver by ID
    public static Driver getDriverById(int id) {
        Driver driver = null;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM driver WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                driver = new Driver(
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("license_number"), rs.getString("phone_number"),
                        rs.getString("car_model"), rs.getBoolean("is_available"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    // Get all drivers
    public static List<Driver> getAllDrivers() {
        List<Driver> driverList = new ArrayList<> ();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM driver";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                driverList.add(new Driver (
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("license_number"), rs.getString("phone_number"),
                        rs.getString("car_model"), rs.getBoolean("is_available")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return driverList;
    }

}
