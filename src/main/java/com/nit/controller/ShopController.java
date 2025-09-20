package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nit.model.Product;
import com.nit.model.Payment;
import com.nit.repository.ProductRepository;
import com.nit.service.PaymentService;

@RestController
@RequestMapping("/shop")
public class ShopController 
{

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) 
    {
        return productRepo.save(product);
    }

    @GetMapping("/products")
    public List<Product> getProducts() 
    {
        return productRepo.findAll();
    }

    @PostMapping("/payment/upi")
    public Payment makePayment(@RequestBody Payment request) 
    {
        return paymentService.makePayment(request.getUpiId(), request.getAmount());
    }

    @GetMapping("/payments")
    public List<Payment> getPayments() 
    {
        return paymentService.getAllPayments();
    }
}
