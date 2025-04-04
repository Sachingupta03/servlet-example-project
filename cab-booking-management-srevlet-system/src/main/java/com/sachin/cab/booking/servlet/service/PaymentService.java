package com.sachin.cab.booking.servlet.service;

import com.sachin.cab.booking.servlet.dao.PaymentDAO;
import com.sachin.cab.booking.servlet.model.Payment;

import java.util.List;

public class PaymentService {

    // Process a new payment
    public boolean processPayment(Payment payment) {
        if (payment.getAmount() <= 0 || payment.getPaymentMethod() == null) {
            throw new IllegalArgumentException("Invalid payment details.");
        }
        return PaymentDAO.addPayment(payment);
    }

    // Get payment details by ID
    public Payment getPaymentById(int id) {
        return PaymentDAO.getPaymentById(id);
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        return PaymentDAO.getAllPayments();
    }

}
