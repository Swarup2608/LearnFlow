package com.learnflow.dto;

import java.math.BigDecimal;

import com.learnflow.model.ExpenseCategory;
import com.learnflow.model.PaymentMethod;
import com.learnflow.model.Account;

public class ExpenseResponse {
    private Long id; // Unique identifier for the expense
    private BigDecimal amount; // Amount of the expense
    private String description; // Description of the expense
    private ExpenseCategory category; // Category of the expense
    private PaymentMethod paymentMethod; // Payment method used for the expense
    private Account account; // Payment Account used for the expense

    public ExpenseResponse(Long id, BigDecimal amount, String description, ExpenseCategory category, PaymentMethod paymentMethod,Account account) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.paymentMethod = paymentMethod;
        this.account = account;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Account getAccount(){
        return this.account;
    }
}
