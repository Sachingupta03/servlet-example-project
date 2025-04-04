package com.sachin.cab.booking.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/CabBooking", "root", "Sachin@10");
            } catch (ClassNotFoundException e) {
                e.printStackTrace ();
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }
        return connection;
    }
}
