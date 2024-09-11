package com.micda.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.micda.bankapi.model.Transaction;
import com.micda.bankapi.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/accounts")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // 3. Historique des transactions avec pagination (GET /accounts/{accountId}/transactions)
    @GetMapping("/{accountId}/transactions")
    public Page<Transaction> getTransactionHistory(
            @PathVariable Long accountId, Pageable pageable) {
        return transactionService.getTransactionHistory(accountId, pageable);
    }
}
