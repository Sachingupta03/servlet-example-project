package com.sachin.cab.booking.servlet.model;

import java.util.Date;

public class Ride {
    private int userId;
    private String pickup;
    private String drop;
    private double fare;
    private String status;

    public Ride(int userId, String pickup, String drop,double fare, String status){
        this.userId= userId;
        this.pickup =pickup;
        this.drop= drop;
        this.fare = fare;
        this.status= status;
    }

    public Ride(int userId, int userId1, String pickup, String drop, double fare, String booked) {
    }

    public Ride() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDrop() {
        return drop;
    }

    public void setDrop(String drop) {
        this.drop = drop;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "userId=" + userId +
                ", pickup='" + pickup + '\'' +
                ", drop='" + drop + '\'' +
                ", fare=" + fare +
                ", status='" + status + '\'' +
                '}';
    }

    public void setUser(User user) {
    }

    public void setPickupLocation(String pickupLocation) {
    }

    public void setDestination(String destination) {
    }

    public void setDriverId(int driverId) {
    }
}