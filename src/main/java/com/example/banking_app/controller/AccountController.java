package com.example.banking_app.controller;

import com.example.banking_app.model.Account;
import com.example.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    //Add Account
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }
    //Get Account By id
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable UUID id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }
    //Deposit Api
    @PutMapping("/{id}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable UUID id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        Account account = accountService.deposit(id, amount);
        return ResponseEntity.ok(account);

    }
    //Withdraw Api
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable UUID id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        Account account = accountService.withdraw(id, amount);
        return ResponseEntity.ok(account);
    }
    //Withdraw Api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable UUID id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.ok("Account Deleted");
    }
    //Get all accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);

    }
}
