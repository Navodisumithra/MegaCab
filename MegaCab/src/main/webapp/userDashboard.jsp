<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Car Rental Dashboard</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome Icons -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
  <!-- Chart.js for Graphs -->
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
  <style>
    :root {
      --primary: #007bff;
      --success: #28a745;
      --danger: #dc3545;
      --grey: #f8f9fa;
    }

    body {
      font-family: 'Arial', sans-serif;
      background-color: var(--grey);
      margin: 0;
      padding: 0;
      display: flex;
      min-height: 100vh;
    }

    /* Sidebar */
    .sidebar {
      width: 250px;
      background: white;
      box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
      transition: width 0.3s;
    }

    .sidebar-brand {
      padding: 1rem;
      background: var(--primary);
      color: white;
      text-align: center;
      font-weight: bold;
    }

    .sidebar-menu {
      list-style: none;
      padding: 0;
    }

    .sidebar-menu-item {
      padding: 1rem;
      margin: 0.5rem 0;
      border-radius: 8px;
      transition: background 0.3s;
      cursor: pointer;
      display: flex;
      align-items: center;
    }

    .sidebar-menu-item:hover {
      background: #f0f0f0;
    }

    .sidebar-menu-item.active {
      background: var(--primary);
      color: white;
    }

    .sidebar-menu-icon {
      margin-right: 1rem;
      width: 24px;
    }

    /* Main Content */
    .main-content {
      flex: 1;
      padding: 1rem;
    }

    .navbar {
      background: white;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      padding: 0.5rem 1rem;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .search-bar {
      position: relative;
      width: 300px;
    }

    .search-bar input {
      width: 100%;
      padding: 0.5rem 2.5rem 0.5rem 1rem;
      border: 1px solid #ddd;
      border-radius: 20px;
    }

    .search-bar i {
      position: absolute;
      right: 10px;
      top: 50%;
      transform: translateY(-50%);
      color: #aaa;
    }

    .user-profile {
      display: flex;
      align-items: center;
    }

    .user-profile img {
      width: 40px;
      height: 40px;
      border-radius: 50%;
      margin-right: 10px;
    }

    /* Stats Cards */
    .stats-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
      gap: 1rem;
      margin-bottom: 1rem;
    }

    .stat-card {
      background: white;
      padding: 1rem;
      border-radius: 8px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      text-align: center;
    }

    .stat-title {
      font-size: 0.9rem;
      color: #666;
    }

    .stat-value {
      font-size: 1.5rem;
      font-weight: bold;
      color: #333;
    }

    /* Charts */
    .chart-container {
      background: white;
      padding: 1rem;
      border-radius: 8px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    /* Responsive Table */
    .data-table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 1rem;
    }

    .data-table th,
    .data-table td {
      padding: 0.75rem;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

    .data-table th {
      background: #f8f9fa;
      font-weight: bold;
    }

    /* Mobile Responsiveness */
    @media (max-width: 768px) {
      .sidebar {
        width: 80px;
      }

      .sidebar-menu-item span {
        display: none;
      }
    }
  </style>
</head>
<body>
<!-- Sidebar -->
<div class="sidebar">
  <div class="sidebar-brand">Mega Cab</div>
  <ul class="sidebar-menu">
    <li class="sidebar-menu-item active" data-section="dashboard">
      <i class="fas fa-tachometer-alt sidebar-menu-icon"></i>
      <span>Dashboard</span>
    </li>
    <li class="sidebar-menu-item" data-section="profile">
      <i class="fas fa-user sidebar-menu-icon"></i>
      <span>My Profile</span>
    </li>
    <li class="sidebar-menu-item" data-section="drivers">
      <i class="fas fa-users sidebar-menu-icon"></i>
      <span>Drivers</span>
    </li>
    <li class="sidebar-menu-item" data-section="bookings">
      <i class="fas fa-calendar-check sidebar-menu-icon"></i>
      <span>Bookings</span>
    </li>
    <li class="sidebar-menu-item" data-section="settings">
      <i class="fas fa-cog sidebar-menu-icon"></i>
      <span>Settings</span>
    </li>
    <li class="sidebar-menu-item" data-section="notifications">
      <i class="fas fa-bell sidebar-menu-icon"></i>
      <span>Notifications</span>
    </li>
    <li class="sidebar-menu-item" data-section="payments">
      <i class="fas fa-wallet sidebar-menu-icon"></i>
      <span>Payment Details</span>
    </li>
  </ul>
</div>

<!-- Main Content -->
<div class="main-content">
  <!-- Navbar -->
  <nav class="navbar">
    <div class="search-bar">
      <input type="text" placeholder="Search..." />
      <i class="fas fa-search"></i>
    </div>
    <div class="user-profile">
      <img src="https://via.placeholder.com/40" alt="Profile Picture" />
      <span> Navodi Sumithra</span>
      <a href="#" class="btn btn-danger btn-sm ms-3">Logout</a>
    </div>
  </nav>

  <!-- Dashboard Section -->
  <div id="dashboard" class="content-section active">
    <h4 class="mb-3">Dashboard</h4>
    <div class="stats-grid">
      <div class="stat-card">
        <div class="stat-title">Total Bookings</div>
        <div class="stat-value">45</div>
      </div>
      <div class="stat-card">
        <div class="stat-title">Available Drivers</div>
        <div class="stat-value">12</div>
      </div>
      <div class="stat-card">
        <div class="stat-title">Earnings</div>
        <div class="stat-value">$8,500</div>
      </div>
    </div>
    <div class="chart-container">
      <canvas id="earningsChart"></canvas>
    </div>
  </div>

  <!-- Profile Section -->
  <div id="profile" class="content-section">
    <h4>My Profile</h4>
    <form>
      <div class="mb-3">
        <label>Name</label>
        <input type="text" class="form-control" />
      </div>
      <div class="mb-3">
        <label>Email</label>
        <input type="email" class="form-control" />
      </div>
      <div class="mb-3">
        <label>Password</label>
        <input type="password" class="form-control" />
      </div>
      <button class="btn btn-primary">Update Profile</button>
    </form>
  </div>

  <!-- Drivers Section -->
  <div id="drivers" class="content-section">
    <h4>Drivers</h4>
    <table class="data-table">
      <thead>
      <tr>
        <th>Name</th>
        <th>Availability</th>
        <th>Earnings</th>
        <th>Ratings</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>John Smith</td>
        <td><span class="badge bg-success">Available</span></td>
        <td>$2,500</td>
        <td>⭐ 4.8</td>
      </tr>
      </tbody>
    </table>
  </div>

  <!-- Bookings Section -->
  <div id="bookings" class="content-section">
    <h4>Bookings</h4>
    <table class="data-table">
      <thead>
      <tr>
        <th>Booking ID</th>
        <th>Car</th>
        <th>Status</th>
        <th>Date</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>#12345</td>
        <td>Toyota Camry</td>
        <td><span class="badge bg-warning">Pending</span></td>
        <td>2025-03-15</td>
      </tr>
      </tbody>
    </table>
  </div>

  <!-- Settings Section -->
  <div id="settings" class="content-section">
    <h4>Settings</h4>
    <form>
      <div class="mb-3">
        <label>Language</label>
        <select class="form-select">
          <option>English</option>
          <option>Spanish</option>
        </select>
      </div>
      <div class="mb-3">
        <label>Theme</label>
        <select class="form-select">
          <option>Light</option>
          <option>Dark</option>
        </select>
      </div>
      <button class="btn btn-primary">Save Changes</button>
    </form>
  </div>

  <!-- Notifications Section -->
  <div id="notifications" class="content-section">
    <h4>Notifications</h4>
    <div class="notification-item">
      <div>Your booking #12345 has been confirmed.</div>
      <div class="text-muted small">2 hours ago</div>
    </div>
  </div>

  <!-- Payment Details Section -->
  <div id="payments" class="content-section">
    <h4>Payment Details</h4>
    <table class="data-table">
      <thead>
      <tr>
        <th>Date</th>
        <th>Amount</th>
        <th>Status</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>2025-03-10</td>
        <td>$500</td>
        <td><span class="badge bg-success">Completed</span></td>
      </tr>
      </tbody>
    </table>
  </div>
</div>

<script>
  // Initialize Chart.js
  const ctx = document.getElementById('earningsChart').getContext('2d');
  new Chart(ctx, {
    type: 'line',
    data: {
      labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May'],
      datasets: [{
        label: 'Earnings',
        data: [1200, 1900, 3000, 2500, 4000],
        borderColor: '#007bff',
        fill: false
      }]
    },
    options: {
      responsive: true,
      maintainAspectRatio: false
    }
  });

  // Sidebar Navigation
  document.querySelectorAll('.sidebar-menu-item').forEach(item => {
    item.addEventListener('click', () => {
      document.querySelectorAll('.sidebar-menu-item').forEach(i => i.classList.remove('active'));
      item.classList.add('active');

      const section = item.getAttribute('data-section');
      document.querySelectorAll('.content-section').forEach(sec => {
        sec.classList.remove('active');
        if (sec.id === section) sec.classList.add('active');
      });
    });
  });
</script>
</body>
</html>