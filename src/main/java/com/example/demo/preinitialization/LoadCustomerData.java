package com.example.demo.preinitialization;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.models.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoadCustomerData {

    @Autowired
    private CustomerRepository customerRepository;

    @Bean(initMethod = "init")
    public void intializeMongoData(){
        customerRepository.deleteAll();
        customerRepository.save(new Customer("John", "Doe"));
        customerRepository.save(new Customer("Son of John", "Doe"));
        customerRepository.save(new Customer("Angelina", "Joe"));
    }
}