<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 3/13/2025
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Edit User</h2>
    <form action="${pageContext.request.contextPath}/userManagement" method="post">
        <input type="hidden" name="id" value="${param.userId}">

        <div class="mb-3">
            <label>Name</label>
            <input type="text" name="name" value="${user.name}" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Address</label>
            <input type="text" name="address" value="${user.address}" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>NIC</label>
            <input type="text" name="nic" value="${user.nic}" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Telephone</label>
            <input type="text" name="telephone" value="${user.telephone}" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Password</label>
            <input type="password" name="password" value="${user.password}" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Email</label>
            <input type="email" name="email" value="${user.email}" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Update User</button>
    </form>
</div>
</body>
</html>
