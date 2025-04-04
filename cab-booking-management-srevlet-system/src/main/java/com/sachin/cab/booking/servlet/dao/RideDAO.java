package com.sachin.cab.booking.servlet.dao;

import com.sachin.cab.booking.servlet.model.Ride;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RideDAO {
    public static boolean bookRide(Ride ride) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO rides (user_id, pickup, drop_location, fare, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ride.getUserId());
            ps.setString(2, ride.getPickup());
            ps.setString(3, ride.getDrop());
            ps.setDouble(4, ride.getFare());
            ps.setString(5, ride.getStatus());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
