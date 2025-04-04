package com.sachin.cab.booking.servlet.service;

import com.sachin.cab.booking.servlet.dao.UserDAO;
import com.sachin.cab.booking.servlet.model.User;

import java.util.List;

public class UserService {

    // Register a new user
    public boolean registerUser(User user) {
        if (user.getName() == null || user.getEmail() == null || user.getPhone() == null) {
            throw new IllegalArgumentException("User details cannot be null.");
        }
        return UserDAO.addUser(user);
    }

    // Get a user by ID
    public User getUserById(int id) {
        return UserDAO.getUserById(id);
    }

    // Get all users
    public List<User> getAllUsers() {
        return UserDAO.getAllUsers();
    }

    // Delete user
    public boolean deleteUser(int id) {
        return UserDAO.deleteUser(id);
    }
}
