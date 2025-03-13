<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 3/7/2025
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            height: 100vh;
            background-color: #f4f4f4;
        }
        .sidebar {
            width: 250px;
            background-color: #2C3E50;
            color: white;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .sidebar h2 {
            margin-bottom: 20px;
        }
        .sidebar a {
            text-decoration: none;
            color: white;
            padding: 10px;
            display: block;
            width: 100%;
            text-align: center;
            border-radius: 5px;
            transition: 0.3s;
        }
        .sidebar a:hover {
            background-color: #34495E;
        }
        .content {
            flex: 1;
            padding: 20px;
        }
        .header {
            background-color: white;
            padding: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .dashboard-cards {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 20px;
            margin-top: 20px;
        }
        .card {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .card i {
            font-size: 40px;
            margin-bottom: 10px;
            color: #3498DB;
        }
    </style>
</head>
<body>
<div class="sidebar">
    <h2>User Dashboard</h2>
        <a href="#"><i class="fas fa-user"></i> Profile</a>
        <a href="cabBooking.jsp"><i class="fas fa-calendar-check"></i> Bookings</a>
        <a href="bill.jsp"><i class="fas fa-credit-card"></i> Payment</a>
        <a href="#"><i class="fas fa-bullhorn"></i> Promotions</a>
        <a href="#"><i class="fas fa-question-circle"></i> Help</a>
        <a href="#"><i class="fas fa-sign-out-alt"></i> Logout</a>
    </div>

</div>
<div class="content">
    <div class="header">
        <h2>  User Dashboard </h2>
    </div>
    <div class="dashboard-cards">
        <div class="card">
            <i class="fas fa-chart-line"></i>
            <h3>Statistics</h3>
            <p>View your stats</p>
        </div>
        <div class="card">
            <i class="fas fa-calendar"></i>
            <h3>Appointments</h3>
            <p>Check your schedule</p>
        </div>
        <div class="card">
            <i class="fas fa-bell"></i>
            <h3>Notifications</h3>
            <p>Latest updates</p>
        </div>
        <div class="card">
            <i class="fas fa-cogs"></i>
            <h3>Settings</h3>
            <p>Customize your experience</p>
        </div>
    </div>
</div>
</body>
</html>
