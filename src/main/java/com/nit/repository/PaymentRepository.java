package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nit.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> 
{
	
}
