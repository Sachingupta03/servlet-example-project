<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cab.booking.model.Driver" %>
<%@ page import="com.cab.booking.service.DriverService" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Available Drivers</title>
    <style>
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .btn {
            padding: 5px 10px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <h2 style="text-align: center;">Available Drivers</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Car Model</th>
            <th>Phone</th>
            <th>Book Ride</th>
        </tr>
        <%
            // Fetch the list of available drivers
            DriverService driverService = new DriverService();
            List<Driver> driverList = driverService.getAvailableDrivers();

            if (driverList != null && !driverList.isEmpty()) {
                for (Driver driver : driverList) {
        %>
        <tr>
            <td><%= driver.getId() %></td>
            <td><%= driver.getName() %></td>
            <td><%= driver.getCarModel() %></td>
            <td><%= driver.getPhoneNumber() %></td>
            <td>
                <form action="book-cab" method="post">
                    <input type="hidden" name="driverId" value="<%= driver.getId() %>">
                    <button type="submit" class="btn">Book</button>
                </form>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5" style="text-align: center; color: red;">No drivers available.</td>
        </tr>
        <% } %>
    </table>

</body>
</html>
