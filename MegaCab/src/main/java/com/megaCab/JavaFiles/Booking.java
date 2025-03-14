package com.megaCab.JavaFiles;

import java.sql.Date;
import java.util.Objects;

/**
 * Represents a booking in the Mega Cab system.
 */
public class Booking {
    private int bookingID;
    private int customerID;
    private String pickupPoint;
    private String destination;
    private Date pickupDate; // SQL Date for database compatibility
    private String carType;
    private double amount;
    private String status;
    private String couponCode;
    private double distance;
    private Date bookedDate; // SQL Date for database compatibility
    private double baseFare;
    private double taxRate;
    private double promotionDiscount;

    /**
     * Default constructor for framework compatibility (e.g., JPA, Hibernate).
     */
    public Booking() {
        // Default constructor
    }

    /**
     * Parameterized constructor for creating a new Booking object.
     *
     * @param bookingID   The unique ID of the booking.
     * @param customerID  The ID of the customer making the booking.
     * @param pickupPoint The pickup location.
     * @param destination The destination location.
     * @param pickupDate  The date and time of pickup.
     * @param carType     The type of car requested.
     * @param amount      The total amount for the booking.
     * @param status      The current status of the booking.
     * @param couponCode  The coupon code applied (if any).
     * @param bookedDate  The date when the booking was made.
     */
    public Booking(int bookingID, int customerID, String pickupPoint, String destination, Date pickupDate,
                   String carType, double amount, String status, String couponCode, Date bookedDate, double distance) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.pickupPoint = pickupPoint;
        this.destination = destination;
        this.pickupDate = pickupDate;
        this.carType = carType;
        this.amount = amount;
        this.status = status;
        this.couponCode = couponCode;
        this.bookedDate = bookedDate;
        this.distance = distance;
    }

    public Booking(int customerID, String pickupPoint, String destination) {
        this.customerID = customerID;
        this.pickupPoint = pickupPoint;
        this.destination = destination;
    }

    // Getters and Setters
    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(String pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
       this.pickupDate = new java.sql.Date(new java.util.Date().getTime());
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Date getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(Date bookedDate) {
        this.bookedDate = bookedDate;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(double promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Returns a string representation of the Booking object.
     *
     * @return A string containing all booking details.
     */
    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", customerID=" + customerID +
                ", pickupPoint='" + pickupPoint + '\'' +
                ", destination='" + destination + '\'' +
                ", pickupDate=" + pickupDate +
                ", carType='" + carType + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", couponCode='" + couponCode + '\'' +
                ", bookedDate=" + bookedDate +
                '}';
    }

    /**
     * Checks if two Booking objects are equal based on their bookingID.
     *
     * @param o The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingID == booking.bookingID;
    }

    /**
     * Generates a hash code for the Booking object based on its bookingID.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(bookingID);
    }



}