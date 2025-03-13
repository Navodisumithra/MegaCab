<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 3/13/2025
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String bookingID = request.getParameter("bookingID");
  String totalAmount = request.getParameter("totalAmount");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Payment Form</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <h4>Make Payment</h4>
  <form action="${pageContext.request.contextPath}/pay" method="post">
    <input type="hidden" name="bookingID" value="<%= bookingID %>">
    <input type="hidden" name="totalAmount" value="<%= totalAmount %>">

    <div class="mb-3">
      <label for="paymentMethod" class="form-label">Payment Method</label>
      <select id="paymentMethod" name="paymentMethod" class="form-control" required>
        <option value="Credit Card">Credit Card</option>
        <option value="PayPal">PayPal</option>
        <option value="Debit Card">Debit Card</option>
      </select>
    </div>

    <div class="mb-3">
      <label for="cardNumber" class="form-label">Card Number</label>
      <input type="text" id="cardNumber" name="cardNumber" class="form-control" placeholder="Enter card number" required>
    </div>

    <div class="mb-3">
      <label for="expiryDate" class="form-label">Expiry Date</label>
      <input type="month" id="expiryDate" name="expiryDate" class="form-control" required>
    </div>

    <div class="mb-3">
      <label for="cvv" class="form-label">CVV</label>
      <input type="text" id="cvv" name="cvv" class="form-control" placeholder="Enter CVV" required>
    </div>

    <button type="submit" class="btn btn-primary">Confirm Payment</button>
  </form>
</div>
</body>
</html>