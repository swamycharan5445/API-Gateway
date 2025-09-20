package com.nit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="payments")
public class Payment 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String upiId;
    private double amount;
    private String status;

    
    public Payment(String upiId, double amount, String status) 
    {
        this.upiId = upiId;
        this.amount = amount;
        this.status = status;
    }

   
}
