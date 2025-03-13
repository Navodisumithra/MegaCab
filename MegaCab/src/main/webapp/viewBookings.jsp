<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 3/13/2025
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <title>Bookings</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h4>Bookings</h4>
    <table class="data-table table table-bordered">
        <thead>
        <tr>
            <th>Booking ID</th>
            <th>Customer ID</th>
            <th>Pickup Point</th>
            <th>Destination</th>
            <th>Car Type</th>
            <th>Status</th>
            <th>Pickup Date</th>
            <th>Amount</th>
            <th>Distance</th>
            <th>Coupon Code</th>
            <th>Fare</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (bookings != null && !bookings.isEmpty()) {
                for (Booking booking : bookings) {
        %>
        <tr>
            <td><%= booking.getBookingID() %></td>
            <td><%= booking.getCustomerID() %></td>
            <td><%= booking.getPickupPoint() %></td>
            <td><%= booking.getDestination() %></td>
            <td><%= booking.getCarType() %></td>
            <td>
                <span class="badge <%= "Pending".equals(booking.getStatus()) ? "bg-warning" :
                                     "Completed".equals(booking.getStatus()) ? "bg-success" :
                                     "Cancelled".equals(booking.getStatus()) ? "bg-danger" : "bg-secondary" %>">
                    <%= booking.getStatus() %>
                </span>
            </td>
            <td><%= booking.getPickupDate() %></td>
            <td>$<%= booking.getAmount() %></td>
            <td><%= booking.getDistance() %> km</td>
            <td><%= booking.getCouponCode() != null ? booking.getCouponCode() : "N/A" %></td>
            <td><%= booking.getBaseFare() %></td>
            <%
                if(!booking.getStatus().equals("Paid")){
            %>
            <td>
                <button onclick="redirectToPayment(<%= booking.getBookingID() %>, <%= booking.getAmount() %>)">Pay</button>
            </td>
            <%
                }
            %>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="12" class="text-center">No bookings found.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <script>
        // Redirect to the payment form with bookingID and totalAmount as query parameters
        function redirectToPayment(bookingID, totalAmount) {
            window.location.href = "${pageContext.request.contextPath}/paymentForm?bookingID=" + bookingID + "&totalAmount=" + totalAmount;
        }
    </script>
</div>
</body>
</html>