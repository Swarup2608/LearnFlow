package com.learnflow.dto;

import java.math.BigDecimal;

import com.learnflow.model.ExpenseCategory;
import com.learnflow.model.PaymentMethod;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CreateExpenseRequest {

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be a positive value")
    private BigDecimal amount; // To Store the Expense Amount

    @NotBlank(message = "Description is required")
    private String description; // To Store the Expense Description

    @NotNull (message = "Category is required")
    private ExpenseCategory category; // To Store the Expense Category

    @NotNull (message = "Payment method is required")
    private PaymentMethod paymentMethod; // To Store the Payment Method

    @NotNull (message = "Account Id is required")
    private Long accountId;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getAccountId(){
        return this.accountId;
    }

    public void setAccountId(Long accountId){
        this.accountId = accountId;
    }
}
