package com.sachin.cab.booking.servlet.model;

public class Payment {
    private int id;
    private int rideId;
    private int userId;
    private double amount;
    private String paymentMethod;
    private String status;

    // Parameterized Constructor
    public Payment(int id, int rideId, int userId, double amount, String paymentMethod, String status) {
        this.id = id;
        this.rideId = rideId;
        this.userId = userId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public Payment(double amount, String method) {
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getRideId() { return rideId; }
    public void setRideId(int rideId) { this.rideId = rideId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Payment{id=" + id + ", rideId=" + rideId + ", userId=" + userId +
                ", amount=" + amount + ", paymentMethod='" + paymentMethod +
                "', status='" + status + "'}";
    }


}
