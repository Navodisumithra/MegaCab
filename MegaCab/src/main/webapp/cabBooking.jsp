<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 2/26/2025
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book a Cab</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* General Styles */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa; /* Light grey background */
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px; /* Restrict form width for better readability */
            margin: 50px auto; /* Center the form on the page */
            padding: 20px;
            background: white; /* White background for the form */
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Subtle shadow for depth */
        }

        h2 {
            text-align: center; /* Center the heading */
            margin-bottom: 20px;
            color: #007bff; /* Blue color for the heading */
        }

        form {
            display: flex;
            flex-direction: column; /* Stack form elements vertically */
        }

        .mb-3 {
            margin-bottom: 1rem; /* Consistent spacing between form fields */
        }

        label {
            font-weight: bold; /* Bold labels for better visibility */
            margin-bottom: 0.5rem; /* Space between label and input */
            color: #333; /* Dark grey for labels */
        }

        input[type="text"],
        input[type="number"],
        input[type="datetime-local"],
        select {
            width: 100%; /* Full width inputs */
            padding: 0.5rem; /* Padding inside input fields */
            border: 1px solid #ced4da; /* Light grey border */
            border-radius: 4px; /* Rounded corners for inputs */
            font-size: 1rem; /* Larger font size for readability */
            transition: border-color 0.3s ease, box-shadow 0.3s ease; /* Smooth transitions */
        }

        input[type="text"]:focus,
        input[type="number"]:focus,
        input[type="datetime-local"]:focus,
        select:focus {
            border-color: #007bff; /* Highlight border on focus */
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.25); /* Subtle glow on focus */
            outline: none; /* Remove default browser outline */
        }

        button[type="submit"] {
            background-color: #007bff; /* Blue button */
            color: white; /* White text */
            border: none; /* No border */
            padding: 0.75rem; /* Padding inside the button */
            font-size: 1rem; /* Larger font size */
            border-radius: 4px; /* Rounded corners */
            cursor: pointer; /* Pointer cursor on hover */
            transition: background-color 0.3s ease; /* Smooth transition for hover effect */
            margin-top: 1rem; /* Add space above the button */
        }

        button[type="submit"]:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .container {
                padding: 15px; /* Reduce padding on smaller screens */
            }

            h2 {
                font-size: 1.25rem; /* Smaller heading on mobile */
            }

            input[type="text"],
            input[type="number"],
            input[type="datetime-local"],
            select {
                font-size: 0.9rem; /* Smaller font size on mobile */
            }

            button[type="submit"] {
                font-size: 0.9rem; /* Smaller button text on mobile */
            }
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Book a Cab</h2>
    <form action="booking" method="post">
        <input type="hidden" name="customerId" value="1">

        <div class="mb-3">
            <label for="pickupPoint" class="form-label">Pickup Point</label>
            <input type="text" id="pickupPoint" name="pickupPoint" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="destination" class="form-label">Destination</label>
            <input type="text" id="destination" name="destination" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="pickupDate" class="form-label">Pickup Date</label>
            <input type="datetime-local" id="pickupDate" name="pickupDate" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="carType" class="form-label">Car Type</label>
            <select id="carType" name="carType" class="form-control">
                <option value="Sedan">Sedan</option>
                <option value="SUV">SUV</option>
                <option value="Van">Van</option>
            </select>
        </div>

        <div class="mb-3">
            <label for="amount" class="form-label">Amount</label>
            <input type="number" id="amount" name="amount" class="form-control" step="0.01" required>
        </div>

        <div class="mb-3">
            <label for="distance" class="form-label">Distance</label>
            <input type="number" id="distance" name="distance" class="form-control" step="0.01" required>
        </div>


    <%--        <div class="mb-3">--%>
<%--            <label for="status" class="form-label">Booking Status</label>--%>
<%--            <select id="status" name="status" class="form-control">--%>
<%--                <option value="Pending">Pending</option>--%>
<%--                <option value="Confirmed">Confirmed</option>--%>
<%--                <option value="Cancelled">Cancelled</option>--%>
<%--                <option value="Completed">Completed</option>--%>
<%--            </select>--%>
<%--        </div>--%>

        <div class="mb-3">
            <label for="couponCode" class="form-label">Coupon Code</label>
            <input type="text" id="couponCode" name="couponCode" class="form-control">
        </div>

        <button type="submit" class="btn btn-primary w-100">Book Now</button>
    </form>
</div>
</body>
</html>