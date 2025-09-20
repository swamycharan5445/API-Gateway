package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.nit.model.Payment;
import com.nit.repository.PaymentRepository;

@Service
public class PaymentService 
{

    @Autowired
    private PaymentRepository paymentRepo;

   
    public Payment makePayment(String upiId, double amount) 
    {
        String status = (amount > 0) ? "SUCCESS" : "FAILED";
        Payment payment = new Payment(upiId, amount, status);
        return paymentRepo.save(payment); 
    }

   
    public List<Payment> getAllPayments() 
    {
        return paymentRepo.findAll();
    }
}
