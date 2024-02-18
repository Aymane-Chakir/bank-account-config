package org.bank.Accountservice.Controller;

import lombok.AllArgsConstructor;
import org.bank.Accountservice.Entity.BankAccount;
import org.bank.Accountservice.Model.Customer;
import org.bank.Accountservice.Repository.BankAccountRepository;
import org.bank.Accountservice.clients.CustomerRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;
    @GetMapping("/accounts")
    public List<BankAccount> bankAccountList(){
        List<BankAccount> accountList = bankAccountRepository.findAll();
        accountList.forEach(
                bankAccount -> bankAccount.setCustomer(customerRestClient.findCustomerById(bankAccount.getCustomerId())));
        return accountList;
    }
    @GetMapping("/account/{id}")
    public BankAccount account(@PathVariable String id){
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
