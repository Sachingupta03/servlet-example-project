<%@ page import="com.cab.booking.model.Driver" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Book a Cab</title>
</head>
<body>
    <h1>Book a Cab</h1>

    <%-- Display error if any --%>
    <% if (request.getAttribute("error") != null) { %>
        <div style="color:red;"><%= request.getAttribute("error") %></div>
    <% } %>

    <form action="${pageContext.request.contextPath}/booking" method="post">
        <label>Pickup Location:</label>
        <input type="text" name="pickupLocation" required><br>

        <label>Destination:</label>
        <input type="text" name="destination" required><br>

        <label>Choose Driver:</label>
        <select name="driverId" required>
            <option value="">-- Select Driver --</option>
            <%
                List<Driver> drivers = (List<Driver>) request.getAttribute("drivers");
                if (drivers != null) {
                    for (Driver driver : drivers) {
            %>
                <option value="<%= driver.getId() %>">
                    <%= driver.getName() %> - <%= driver.getCarModel() %>
                </option>
            <%
                    }
                }
            %>
        </select><br>

        <input type="submit" value="Book Cab">
    </form>
</body>
</html>