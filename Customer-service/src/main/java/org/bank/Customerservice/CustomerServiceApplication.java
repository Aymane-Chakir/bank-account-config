package org.bank.Customerservice;

import org.bank.Customerservice.Config.GlobalConfig;
import org.bank.Customerservice.Entity.Customer;
import org.bank.Customerservice.Repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			List<Customer> customerList =List.of(

					Customer.builder()
					.email("aymane.hhh.u")
					.firstName("aymane")
			 		.lastName("chakir")
					.build(),
					Customer.builder()
							.email("rabii@outlook.com")
							.firstName("rabii")
							.lastName("khouba")
							.build()
			);
			customerRepository.saveAll(customerList);
		};
	}
}
