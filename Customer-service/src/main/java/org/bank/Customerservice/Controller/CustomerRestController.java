package org.bank.Customerservice.Controller;

import lombok.AllArgsConstructor;
import org.bank.Customerservice.Entity.Customer;
import org.bank.Customerservice.Repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestController {
    private CustomerRepository customerRepository;


    @GetMapping("/customer")
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }

    @GetMapping("customer/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }

}
