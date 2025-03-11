<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 3/11/2025
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Booking Failed</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    /* General Styles */
    body {
      font-family: 'Arial', sans-serif;
      background-color: #f8f9fa; /* Light grey background */
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
    }

    .container {
      max-width: 500px; /* Restrict container width for better readability */
      text-align: center;
      padding: 2rem;
      background: white; /* White background for the box */
      border-radius: 8px; /* Rounded corners */
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Subtle shadow for depth */
    }

    h2 {
      color: #dc3545; /* Red color for failure */
      margin-bottom: 1rem;
    }

    p {
      font-size: 1rem;
      color: #333; /* Dark grey text */
      margin-bottom: 2rem;
    }

    .btn-primary {
      background-color: #007bff; /* Blue button */
      border: none;
      padding: 0.75rem 1.5rem;
      font-size: 1rem;
      border-radius: 4px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    .btn-primary:hover {
      background-color: #0056b3; /* Darker blue on hover */
    }

    /* Responsive Design */
    @media (max-width: 768px) {
      .container {
        padding: 1.5rem;
      }

      h2 {
        font-size: 1.5rem;
      }

      p {
        font-size: 0.9rem;
      }

      .btn-primary {
        font-size: 0.9rem;
        padding: 0.6rem 1.2rem;
      }
    }
  </style>
</head>
<body>
<div class="container">
  <h2 class="text-danger">Booking Failed!</h2>
  <p>Sorry, there was an issue processing your booking. Please try again later.</p>
  <a href="${pageContext.request.contextPath}/jsp/cabBookingForm.jsp" class="btn btn-primary">Try Again</a>
</div>
</body>
</html>
