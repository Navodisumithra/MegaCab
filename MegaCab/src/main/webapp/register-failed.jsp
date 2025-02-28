<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 2/27/2025
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mega Cab - Registration Failed</title>
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
        h2 { color: #dc3545; margin-bottom: 20px; }
        p { color: #333; margin-bottom: 20px; }
        a {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
        }
        a:hover { background-color: #0056b3; }
    </style>
</head>
<body>
<div class="container">
    <h2>Registration Failed!</h2>
    <p>Sorry, there was an issue with your registration. Please try again.</p>
    <a href="register.jsp">Retry Registration</a>
</div>
</body>
</html>
