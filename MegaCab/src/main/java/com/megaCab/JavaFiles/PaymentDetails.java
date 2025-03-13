package com.megaCab.JavaFiles;

public class PaymentDetails {
        private int paymentID;
        private int bookingID;
        private double totalAmount;
        private String paymentMethod;
        private String paymentStatus;

        // Getters and Setters
        public int getPaymentID() { return paymentID; }
        public void setPaymentID(int paymentID) { this.paymentID = paymentID; }

        public int getBookingID() { return bookingID; }
        public void setBookingID(int bookingID) { this.bookingID = bookingID; }

        public double getTotalAmount() { return totalAmount; }
        public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

        public String getPaymentMethod() { return paymentMethod; }
        public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

        public String getPaymentStatus() { return paymentStatus; }
        public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    }

