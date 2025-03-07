<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 3/6/2025
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2>Admin Dashboard</h2>
    <ul class="nav nav-tabs">
        <li class="nav-item"><a class="nav-link" href="/admin/dashboard?action=bookings">Manage Bookings</a></li>
        <li class="nav-item"><a class="nav-link" href="/admin/dashboard?action=drivers">Manage Drivers</a></li>
        <li class="nav-item"><a class="nav-link" href="/admin/dashboard?action=users">Manage Users</a></li>
        <li class="nav-item"><a class="nav-link" href="/admin/dashboard?action=vehicles">Manage Vehicles</a></li>
        <li class="nav-item"><a class="nav-link" href="/admin/dashboard?action=promotions">Manage Promotions</a></li>
    </ul>
</div>
</body>
</html>
