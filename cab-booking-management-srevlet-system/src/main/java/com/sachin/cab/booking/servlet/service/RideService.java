package com.sachin.cab.booking.servlet.service;

import com.sachin.cab.booking.servlet.dao.RideDAO;
import com.sachin.cab.booking.servlet.model.Driver;
import com.sachin.cab.booking.servlet.model.Ride;

import java.util.List;

public class RideService {
    public boolean bookRide(Ride ride) {
        return RideDAO.bookRide(ride);
    }

    public List<Driver> getAvailableDrivers() {
        return List.of ();
    }
}
