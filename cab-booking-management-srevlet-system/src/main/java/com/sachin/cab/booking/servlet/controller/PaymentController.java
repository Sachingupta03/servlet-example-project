package com.sachin.cab.booking.servlet.controller;

import com.sachin.cab.booking.servlet.model.Payment;
import com.sachin.cab.booking.servlet.service.PaymentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PaymentController extends HttpServlet {
    private PaymentService paymentService = new PaymentService();

    // Process Payment
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        double amount = Double.parseDouble(request.getParameter("amount"));
        String method = request.getParameter("method");

        Payment payment = new Payment(amount, method);
        boolean isProcessed = paymentService.processPayment(payment);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(isProcessed ? "{\"message\": \"Payment Processed\"}" : "{\"error\": \"Payment Failed\"}");
    }

    // Get Payment by ID or All Payments
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        if (pathInfo == null || pathInfo.equals("/all")) {
            List<Payment> payments = paymentService.getAllPayments();
            out.print(payments.toString());
        } else {
            int paymentId = Integer.parseInt(pathInfo.substring(1));
            Payment payment = paymentService.getPaymentById(paymentId);
            out.print(payment != null ? payment.toString() : "{\"error\": \"Payment Not Found\"}");
        }
    }


}
