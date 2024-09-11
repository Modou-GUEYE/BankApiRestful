package com.micda.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.micda.bankapi.model.Transaction;
import com.micda.bankapi.repository.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Méthode pour obtenir l'historique des transactions d'un compte avec pagination
    @Transactional
    public Page<Transaction> getTransactionHistory(Long accountId, Pageable pageable) {
        return transactionRepository.findByAccount_Id(accountId, pageable);
    }
}

