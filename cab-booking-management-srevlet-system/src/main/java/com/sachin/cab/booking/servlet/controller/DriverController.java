package com.sachin.cab.booking.servlet.controller;

import com.sachin.cab.booking.servlet.model.Driver;
import com.sachin.cab.booking.servlet.service.DriverService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DriverController extends HttpServlet {
    private DriverService driverService = new DriverService ();

    // Register Driver
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String name = request.getParameter ("name");
        String license = request.getParameter ("license");

        Driver driver = new Driver (name, license);
        boolean isRegistered = driverService.registerDriver (driver);

        response.setContentType ("application/json");
        PrintWriter out = response.getWriter ();
        out.print (isRegistered ? "{\"message\": \"Driver Registered\"}" : "{\"error\": \"Registration Failed\"}");
    }

    // Get Driver by ID or All Drivers
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo ();
        response.setContentType ("application/json");
        PrintWriter out = response.getWriter ();

        if (pathInfo == null || pathInfo.equals ("/all")) {
            List<Driver> drivers = driverService.getAllDrivers ();
            out.print (drivers.toString ());
        } else {
            int driverId = Integer.parseInt (pathInfo.substring (1));
            Driver driver = driverService.getDriverById (driverId);
            out.print (driver != null ? driver.toString () : "{\"error\": \"Driver Not Found\"}");
        }
    }


}
