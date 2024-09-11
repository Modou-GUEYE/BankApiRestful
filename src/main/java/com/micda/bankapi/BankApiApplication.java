package com.micda.bankapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.micda.bankapi.model.Account;
import com.micda.bankapi.repository.AccountRepository;


@SpringBootApplication
public class BankApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner  startAppliRunner(AccountRepository accountRepository) {
		return args -> {
			accountRepository.save(Account.builder().accountNumber("123456789").balance(1000000.0).build());
			accountRepository.save(Account.builder().accountNumber("987654321").balance(20000000.0).build());
		};
	}
	

	
}