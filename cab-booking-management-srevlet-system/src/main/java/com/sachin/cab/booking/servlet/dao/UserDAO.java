package com.sachin.cab.booking.servlet.dao;

import com.sachin.cab.booking.servlet.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    // Insert new user
    public static boolean addUser(User user) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO users (name, email, phone) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get user by ID
    public static User getUserById(int id) {
        User user = null;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // Get all users
    public static List<User> getAllUsers() {
        List<User> userList = new ArrayList<> ();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM users";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                userList.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("phone")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    // Delete user by ID
    public static boolean deleteUser(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
