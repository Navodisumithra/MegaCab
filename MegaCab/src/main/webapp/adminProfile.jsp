<%@ page import="com.megaCab.JavaFiles.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getSession().getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .profile-container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
        }
        h2 {
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            font-weight: bold;
            margin-top: 10px;
        }
        input {
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            margin-top: 15px;
            padding: 10px;
            border: none;
            background: #007bff;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
<div class="profile-container">
    <h2>Admin Profile</h2>
    <form action="${pageContext.request.contextPath}/updateProfile" method="post">
        <input type="hidden" name="id" value='<%=user.getId()%>'>

        <label>Name:</label>
        <input type="text" name="name" value='<%=user.getName()%>'>

        <label>Address:</label>
        <input type="text" name="address" value='<%=user.getAddress()%>'>

        <label>NIC:</label>
        <input type="text" name="nic" value='<%=user.getNic()%>'>

        <label>Telephone:</label>
        <input type="text" name="telephone" value='<%=user.getTelephone()%>'>

        <label>Email:</label>
        <input type="email" name="email" value='<%=user.getEmail()%>'>

        <label>Password:</label>
        <input type="password" name="password" value="">

        <button type="submit">Update Profile</button>
    </form>
</div>
</body>
</html>