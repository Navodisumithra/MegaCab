<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 3/14/2025
  Time: 1:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.megaCab.JavaFiles.Driver" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Driver> drivers = (List<Driver>) request.getAttribute("drivers");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Drivers</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Manage Drivers</h2>

    <!-- Add Driver Form -->
    <form action="${pageContext.request.contextPath}/drivers" method="post" class="mb-4">
        <div class="row">
            <div class="col-md-3">
                <input type="text" name="name" class="form-control" placeholder="Name" required>
            </div>
            <div class="col-md-3">
                <input type="text" name="phone" class="form-control" placeholder="Phone" required>
            </div>
            <div class="col-md-3">
                <input type="email" name="email" class="form-control" placeholder="Email" required>
            </div>
            <div class="col-md-3">
                <input type="text" name="licenseNumber" class="form-control" placeholder="License Number" required>
            </div>
            <div class="col-md-3 mt-2">
                <select name="isAvailable" class="form-select" required>
                    <option value="true">Available</option>
                    <option value="false">Unavailable</option>
                </select>
            </div>
            <div class="col-md-3 mt-2">
                <button type="submit" class="btn btn-primary">Add Driver</button>
            </div>
        </div>
    </form>

    <!-- Driver Table -->
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>License Number</th>
            <th>Availability</th>
            <th>Created At</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (drivers != null && !drivers.isEmpty()) {
                for (Driver driver : drivers) {
        %>
        <tr>
            <td><%= driver.getDriverId() %></td>
            <td><%= driver.getName() %></td>
            <td><%= driver.getPhone() %></td>
            <td><%= driver.getEmail() %></td>
            <td><%= driver.getLicenseNumber() %></td>
            <td><%= driver.isAvailable() ? "Available" : "Unavailable" %></td>
            <td><%= driver.getCreatedAt() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="7" class="text-center">No drivers found.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/adminDashboard.jsp">Back to Dashboard</a>
</div>
</body>
</html>