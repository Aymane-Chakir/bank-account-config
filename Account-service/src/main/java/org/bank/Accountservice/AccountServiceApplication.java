package org.bank.Accountservice;

import org.bank.Accountservice.Entity.BankAccount;
import org.bank.Accountservice.Enums.AccountType;
import org.bank.Accountservice.Repository.BankAccountRepository;
import org.bank.Accountservice.clients.CustomerRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	@Bean
CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient){
		return args -> {
			customerRestClient.allCustomer().forEach(customer -> {
				BankAccount bankAccount=
						BankAccount.builder()
								.customerId(customer.getId())
								.balance(Math.random()*100000)
								.createAt(LocalDate.now())
								.type(AccountType.CURRENT_ACCOUNT)
								.currency("Mad")
								.build();
				BankAccount bankAccount2=
						BankAccount.builder()
								.customerId(customer.getId())
								.balance(Math.random()*100000)
								.createAt(LocalDate.now())
								.type(AccountType.CURRENT_ACCOUNT)
								.currency("Mad")
								.build();

				bankAccountRepository.save(bankAccount);
				bankAccountRepository.save(bankAccount2);


			});

		};
}
}
