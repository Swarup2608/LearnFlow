package com.learnflow.service;

import com.learnflow.model.Account;
import com.learnflow.model.Expense;
import com.learnflow.repository.AccountRepository;
import com.learnflow.repository.ExpenseRepository;
import com.learnflow.dto.CreateExpenseRequest;
import com.learnflow.dto.ExpenseResponse;
import com.learnflow.dto.UpdateExpenseRequest;
import com.learnflow.exception.InsufficientBalanceException;
import com.learnflow.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final AccountRepository accountRepository;

    private ExpenseResponse mapToExpenseResponse(Expense expense) {
        return new ExpenseResponse(
            expense.getId(),
            expense.getAmount(),
            expense.getDescription(),
            expense.getCategory(),
            expense.getPaymentMethod(),
            expense.getAccount()
        );
    }

    public ExpenseService(ExpenseRepository expenseRepository, AccountRepository accountRepository) {
        this.expenseRepository = expenseRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public ExpenseResponse createExpense(CreateExpenseRequest request) {

        Account account = accountRepository.findById(request.getAccountId()).orElseThrow(() -> new ResourceNotFoundException( "Account not found with id: " + request.getAccountId()));
        
        if (account.getBalance().compareTo(request.getAmount()) < 0) {
            throw new InsufficientBalanceException("Insufficient balance in account: " + account.getName());
        }

        Expense expense = new Expense(
            request.getAmount(),
            request.getDescription(),
            request.getCategory(),
            request.getPaymentMethod(),
            account
        );

        Expense savedExpense = expenseRepository.save(expense);

        
        account.setBalance(account.getBalance().subtract(request.getAmount()));
        accountRepository.save(account);

        return new ExpenseResponse(
            savedExpense.getId(),
            savedExpense.getAmount(),
            savedExpense.getDescription(),
            savedExpense.getCategory(),
            savedExpense.getPaymentMethod(),
            savedExpense.getAccount()
        );
    }

    public List<ExpenseResponse> getAllExpenses() {
        return expenseRepository.findAll().stream()
                .map(this::mapToExpenseResponse)
                .toList();
    }

    public ExpenseResponse getExpenseById(Long id){
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id ));

         return new ExpenseResponse(
            expense.getId(),
            expense.getAmount(),
            expense.getDescription(),
            expense.getCategory(),
            expense.getPaymentMethod(),
            expense.getAccount()
        );

    }

    public ExpenseResponse updateExpense( Long id, UpdateExpenseRequest request) {

        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "Expense not found with id: " + id ));
        expense.setAmount(request.getAmount());
        expense.setDescription(request.getDescription());
        expense.setCategory(request.getCategory());
        expense.setPaymentMethod(request.getPaymentMethod());
        Expense updatedExpense = expenseRepository.save(expense);

        return new ExpenseResponse(
            updatedExpense.getId(),
            updatedExpense.getAmount(),
            updatedExpense.getDescription(),
            updatedExpense.getCategory(),
            updatedExpense.getPaymentMethod(),
            updatedExpense.getAccount()
        );
    }
    
    public void deleteExpense(Long id){
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "Expense not found with id: " + id ));
    
        expenseRepository.delete(expense);
    }


}
