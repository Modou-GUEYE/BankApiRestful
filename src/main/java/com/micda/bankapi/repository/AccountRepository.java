package com.micda.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.micda.bankapi.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
