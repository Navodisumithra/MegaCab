<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 3/14/2025
  Time: 12:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.megaCab.JavaFiles.Vehicle" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vehicles</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Manage Vehicles</h2>

    <!-- Add Vehicle Form -->
    <form action="${pageContext.request.contextPath}/vehicles" method="post" class="mb-4">
        <div class="row">
            <div class="col-md-3">
                <input type="text" name="name" class="form-control" placeholder="Name" required>
            </div>
            <div class="col-md-3">
                <input type="text" name="type" class="form-control" placeholder="Type" required>
            </div>
            <div class="col-md-3">
                <select name="availability" class="form-select" required>
                    <option value="true">Available</option>
                    <option value="false">Unavailable</option>
                </select>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-primary">Add Vehicle</button>
            </div>
        </div>
    </form>

    <!-- Vehicle Table -->
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Type</th>
            <th>Availability</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (vehicles != null && !vehicles.isEmpty()) {
                for (Vehicle vehicle : vehicles) {
        %>
        <tr>
            <td><%= vehicle.getId() %></td>
            <td><%= vehicle.getName() %></td>
            <td><%= vehicle.getType() %></td>
            <td><%= vehicle.isAvailability() ? "Available" : "Unavailable" %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="4" class="text-center">No vehicles found.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
