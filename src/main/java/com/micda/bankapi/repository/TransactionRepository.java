package com.micda.bankapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.micda.bankapi.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findByAccount_Id(Long accountId, Pageable pageable);
}
