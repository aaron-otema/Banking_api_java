package com.example.banking_app.service;

import com.example.banking_app.model.Account;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    Account createAccount(Account account);
    Account getAccountById(UUID id);
    Account deposit(UUID id, Double amount);
    Account withdraw(UUID id, Double amount);
    void deleteAccountById(UUID id);
    List<Account> getAllAccounts();
}
