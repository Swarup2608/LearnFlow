package com.learnflow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity 
@Table (name = "accounts")
public class Account {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column (precision = 19, scale = 2, nullable = false)
    private  BigDecimal balance;

    public Account(){
    }

    public Account(String name, BigDecimal balance){
        this.name = name;
        this.balance = balance;
    }

    // Getters
    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public BigDecimal getBalance(){
        return balance;
    }


    // Setters
    public void setName(String name){
        this.name = name;
    }

    public void setBalance(BigDecimal balance){
        this.balance = balance;
    }

}
