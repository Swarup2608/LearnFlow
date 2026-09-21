package com.learnflow.service;

import com.learnflow.dto.AccountResponse;
import com.learnflow.dto.CreateAccountRequest;
import com.learnflow.model.Account;
import com.learnflow.repository.AccountRepository;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse createAccount(CreateAccountRequest request) {

        Account account = new Account(
                request.getName(),
                request.getBalance()
        );

        Account savedAccount = accountRepository.save(account);

        return new AccountResponse(
                savedAccount.getId(),
                savedAccount.getName(),
                savedAccount.getBalance()
        );
    }
}