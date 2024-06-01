package com.example.banking_app.service;

import com.example.banking_app.model.Account;
import com.example.banking_app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);

    }

    @Override
    public Account getAccountById(UUID id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does not Exist"));
        return account;
    }

    @Override
    public Account deposit(UUID id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does not Exist"));
        double total = account.getAccountBalance() + amount;
        account.setAccountBalance(total);
        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    @Override
    public Account withdraw(UUID id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does not Exist"));
        if (account.getAccountBalance() < amount ) {
            throw new RuntimeException("Insufficient Balance");
        }
        double total = account.getAccountBalance() - amount;
        account.setAccountBalance(total);
        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    @Override
    public void deleteAccountById(UUID id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does not Exist"));
        accountRepository.deleteById(id);

    }

    @Override
    public List<Account> getAllAccounts() {
    List<Account> accounts = accountRepository.findAll();
        return accounts;
    }
}
