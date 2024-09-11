package com.micda.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.micda.bankapi.service.AccountService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

//    Consultation du solde du compte (GET /accounts/{accountId}/balance)
    @GetMapping("/{accountId}/balance")
    public BigDecimal getAccountBalance(@PathVariable Long accountId) {
        return accountService.getBalance(accountId);
    }

//    Effectuer un virement (POST /accounts/{accountId}/transfer)
    @PostMapping("/{accountId}/transfer")
    public void transferFunds(
            @PathVariable Long accountId,
            @RequestParam Long toAccountId,
            @RequestParam Double amount) {
        accountService.transferFunds(accountId, toAccountId, amount);
    }
}