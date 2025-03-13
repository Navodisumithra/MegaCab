<%--Created by IntelliJ IDEA.
User: Windows
Date: 3/11/2025
Time: 8:50 PM
To change this template use File | Settings | File Templates.--%>
<%@ page import="com.megaCab.JavaFiles.Booking" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Manage Bookings</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Manage Bookings</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Booking ID</th>
            <th>Customer ID</th>
            <th>Pickup Point</th>
            <th>Destination</th>
            <th>Pickup Date</th>
            <th>Car Type</th>
            <th>Amount</th>
            <th>Status</th>
            <th>Coupon Code</th>
            <th>Booked Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%

            for (Booking booking : bookings) {
                out.println("<tr>");
                out.println("<td>" + booking.getBookingID() + "</td>");
                out.println("<td>" + booking.getCustomerID() + "</td>");
                out.println("<td>" + booking.getPickupPoint() + "</td>");
                out.println("<td>" + booking.getDestination() + "</td>");
                out.println("<td>" + booking.getPickupDate() + "</td>");
                out.println("<td>" + booking.getCarType() + "</td>");
                out.println("<td>" + booking.getAmount() + "</td>");
                out.println("<td>" + booking.getStatus() + "</td>");
                out.println("<td>" + booking.getCouponCode() + "</td>");
                out.println("<td>" + booking.getBookedDate() + "</td>");
                out.println("<td>");
                out.println("<a href='" + request.getContextPath() + "/admin/updateBooking?bookingID=" + booking.getBookingID() + "' class='btn btn-sm btn-primary'>Edit</a>");
                out.println("<a href='" + request.getContextPath() + "/admin/deleteBooking?bookingID=" + booking.getBookingID() + "' class='btn btn-sm btn-danger'>Delete</a>");
                out.println("</td>");
                out.println("</tr>");
            }

        %>
        </tbody>
    </table>
</div>
</body>
</html>