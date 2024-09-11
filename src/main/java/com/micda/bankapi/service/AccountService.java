package com.micda.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.micda.bankapi.model.Account;
import com.micda.bankapi.repository.AccountRepository;

import java.math.BigDecimal;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Récupérer le solde d'un compte
    public BigDecimal getBalance(Long accountId) {
        Account account = accountRepository.findById(accountId)
            .orElseThrow(() -> new RuntimeException("Compte non trouvé"));
        return BigDecimal.valueOf(account.getBalance());
    }

    // Effectuer un virement entre deux comptes
    public void transferFunds(Long fromAccountId, Long toAccountId, Double amount) {
        Account fromAccount = accountRepository.findById(fromAccountId)
            .orElseThrow(() -> new RuntimeException("Compte débiteur non trouvé"));
        Account toAccount = accountRepository.findById(toAccountId)
            .orElseThrow(() -> new RuntimeException("Compte créditeur non trouvé"));

        if (fromAccount.getBalance() >= amount) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);

            accountRepository.save(fromAccount);
            accountRepository.save(toAccount);
        } else {
            throw new RuntimeException("Solde insuffisant pour le transfert");
        }
    }
}