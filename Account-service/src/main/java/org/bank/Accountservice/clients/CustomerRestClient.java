package org.bank.Accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.bank.Accountservice.Model.Customer;
import org.bank.Accountservice.Repository.BankAccountRepository;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")

public interface CustomerRestClient {

    @GetMapping("/customer/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/customer")
    List<Customer> allCustomer();
    default Customer getDefaultCustomer(Long id , Exception e){
        Customer customer= new Customer();
        customer.setId(id);
        customer.setFirstName("not Available");
        customer.setLastName("not Available");
        customer.setEmail("Not Available");
      return customer;
    };

}
