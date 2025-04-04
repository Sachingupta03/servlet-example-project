package com.sachin.cab.booking.servlet.controller;

import com.sachin.cab.booking.servlet.model.Ride;
import com.sachin.cab.booking.servlet.service.RideService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RideController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        int userId = Integer.parseInt(request.getParameter("userId"));
        String pickup = request.getParameter("pickup");
        String drop = request.getParameter("drop");
        double fare = Double.parseDouble(request.getParameter("fare"));

        Ride ride = new Ride(0, userId, pickup, drop, fare, "Booked");
        RideService rideService = new RideService();
        boolean success = rideService.bookRide(ride);

        if (success) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("failure.jsp");
        }
    }

}
