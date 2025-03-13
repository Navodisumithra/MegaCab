<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 3/13/2025
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.megaCab.JavaFiles.PaymentDetails" %>
<%
    PaymentDetails paymentDetails = (PaymentDetails) request.getAttribute("paymentDetails");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Bill  Payment </title>
</head>
<body>
<h2>Payment Successful!</h2>
<p>Total Amount: <%= paymentDetails.getTotalAmount() %></p>
<p>Payment Method: <%= paymentDetails.getPaymentMethod() %></p>
<p>Status: <%= paymentDetails.getPaymentStatus() %></p>
<a href="${pageContext.request.contextPath}/customerDashboard.jsp?action=bookings">Back to Home</a>
</body>
</html>
