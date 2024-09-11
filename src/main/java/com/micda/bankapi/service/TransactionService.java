package com.micda.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.micda.bankapi.model.Transaction;
import com.micda.bankapi.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Récupérer l'historique des transactions avec pagination
    public Page<Transaction> getTransactionHistory(Long accountId, Pageable pageable) {
        return transactionRepository.findByAccount_Id(accountId, pageable);
    }
}
