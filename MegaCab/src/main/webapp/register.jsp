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
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Poppins', sans-serif;
            background-size: cover;
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: rgba(255, 255, 255, 0.9);
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 400px;
        }
        h2 { color: #333; margin-bottom: 20px; }
        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            background-color: #28a745;
            color: white;
            padding: 10px;
            width: 100%;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover { background-color: #218838; }
    </style>
</head>
<body>
<div class="container">
    <h2>User Registration</h2>
    <form action="register" method="post">
        <input type="text" name="name" placeholder="Enter your name" required>
        <input type="text" name="address" placeholder="Enter your address" required>
        <input type="text" name="nic" placeholder="Enter your NIC" required>
        <input type="tel" name="telephone" placeholder="Enter your telephone no." required>
        <button type="submit">Register</button>
    </form>
</div>
</body>
</html>

