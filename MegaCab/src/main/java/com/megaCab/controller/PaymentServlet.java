package com.megaCab.controller;

import com.megaCab.JavaFiles.PaymentDetails;
import com.megaCab.Services.PaymentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class PaymentServlet extends HttpServlet {


        private PaymentService paymentService;

        public void init() {
            paymentService = new PaymentService();
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            PaymentDetails paymentDetails = new PaymentDetails();
            paymentDetails.setBookingID(Integer.parseInt(request.getParameter("bookingID")));
            paymentDetails.setTotalAmount(Double.parseDouble(request.getParameter("totalAmount")));
            paymentDetails.setPaymentMethod(request.getParameter("paymentMethod"));

           if(paymentService.processPayment(paymentDetails)){
               request.setAttribute("paymentDetails", paymentDetails);
               RequestDispatcher dispatcher = request.getRequestDispatcher("bill.jsp");
               dispatcher.forward(request, response);
           }
           else{
               RequestDispatcher dispatcher = request.getRequestDispatcher("customerDashboard?action=bookings&error=payment+add+failed");
               dispatcher.forward(request, response);
           }


        }
    }

