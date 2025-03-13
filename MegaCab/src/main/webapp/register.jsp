<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 2/26/2025
  Time: 12:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mega Cab - User Registration</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    <style>
        /* ... [keep your existing CSS styles here] ... */
    </style>
</head>
<body>
<div class="container">
    <h2>User Registration</h2>
    <form action="register" method="post">
        <input type="text" name="name" placeholder="Full Name" required>
        <input type="text" name="email" placeholder="Email " required>
        <input type="text" name="address" placeholder="Address" required>
        <input type="text" name="nic" placeholder="NIC (e.g., 123456789V)" required>
        <input type="tel" name="telephone" placeholder="Telephone (e.g., 0771234567)" required>
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required> <!-- Changed to password type <button class="citation-flag" data-index="9"> -->
        <input type="password" name="confirmPassword" placeholder="Confirm Password" required> <!-- Fixed name attribute <button class="citation-flag" data-index="1"> -->
        <button type="submit">Register</button>
    </form>
</div>
</body>
</html>

