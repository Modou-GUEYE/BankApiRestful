package com.micda.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.micda.bankapi.model.Transaction;
import com.micda.bankapi.service.TransactionService;

@RestController
@RequestMapping("/accounts")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Endpoint pour obtenir l'historique des transactions d'un compte avec pagination
    @GetMapping("/{accountId}/transactions")
    public Page<Transaction> getTransactionHistory(
            @PathVariable Long accountId, Pageable pageable) {
        return transactionService.getTransactionHistory(accountId, pageable);
    }
}
