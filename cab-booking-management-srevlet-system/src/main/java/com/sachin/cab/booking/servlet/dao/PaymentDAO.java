package com.sachin.cab.booking.servlet.dao;

import com.sachin.cab.booking.servlet.model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
    // Insert new payment
    public static boolean addPayment(Payment payment) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO payment (ride_id, user_id, amount, payment_method, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, payment.getRideId());
            ps.setInt(2, payment.getUserId());
            ps.setDouble(3, payment.getAmount());
            ps.setString(4, payment.getPaymentMethod());
            ps.setString(5, payment.getStatus());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get payment by ID
    public static Payment getPaymentById(int id) {
        Payment payment = null;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM payment WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                payment = new Payment(
                        rs.getInt("id"), rs.getInt("ride_id"),
                        rs.getInt("user_id"), rs.getDouble("amount"),
                        rs.getString("payment_method"), rs.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return payment;
    }

    // Get all payments
    public static List<Payment> getAllPayments() {
        List<Payment> paymentList = new ArrayList<> ();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM payment";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                paymentList.add(new Payment (
                        rs.getInt("id"), rs.getInt("ride_id"),
                        rs.getInt("user_id"), rs.getDouble("amount"),
                        rs.getString("payment_method"), rs.getString("status")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentList;
    }



}
