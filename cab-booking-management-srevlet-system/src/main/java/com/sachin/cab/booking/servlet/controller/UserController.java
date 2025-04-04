
package com.sachin.cab.booking.servlet.controller;

import com.sachin.cab.booking.servlet.model.User;
import com.sachin.cab.booking.servlet.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserController extends HttpServlet {
    private UserService userService = new UserService ();

    // Register User
     protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
         String name = request.getParameter("name");
         String email = request.getParameter("email");
         String phone = request.getParameter("phone");

         User user = new User(name, email, phone);
         boolean isRegistered = userService.registerUser(user);

         response.setContentType("application/json");
         PrintWriter out = response.getWriter();
         if (isRegistered) {
             out.print("{\"message\": \"User Registered Successfully\"}");
         } else {
             out.print("{\"error\": \"Registration Failed\"}");
         }
     }

    // Get User by ID
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        if (pathInfo == null || pathInfo.equals("/all")) {
            List<User> users = userService.getAllUsers();
            out.print(users.toString());
        } else {
            int userId = Integer.parseInt(pathInfo.substring(1));
            User user = userService.getUserById(userId);
            out.print(user != null ? user.toString() : "{\"error\": \"User Not Found\"}");
        }
    }

    // Delete User
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userId = Integer.parseInt(request.getPathInfo().substring(1));
        boolean isDeleted = userService.deleteUser(userId);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(isDeleted ? "{\"message\": \"User Deleted\"}" : "{\"error\": \"Deletion Failed\"}");
    }
     }


