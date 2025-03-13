package com.megaCab.Services;

import com.megaCab.JavaFiles.PaymentDetails;
import com.megaCab.dao.BookingDAO;
import com.megaCab.dao.PaymentDao;

public class PaymentService {

    private PaymentDao paymentDao = new PaymentDao();
    private BookingDAO  bookingDao = new BookingDAO();
    public boolean processPayment(PaymentDetails paymentDetails) {
        if(paymentDao.makePayment(paymentDetails)){
            return bookingDao.updateBookingStatus(paymentDetails.getBookingID(), "Paid");
        }
        return false;
    }
}






