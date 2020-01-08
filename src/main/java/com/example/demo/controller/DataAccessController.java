package com.example.demo.controller;

import java.util.List;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.models.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo")
public class DataAccessController {

  @Autowired
  private CustomerRepository customerRepository;

  @RequestMapping(path="firstname/{id}")
  public String getByFirstName(@PathVariable(value = "id") String name) {
    return customerRepository.findByFirstName(name).toString();
  }

  @RequestMapping(path="lastname/{id}")
  public String getByLastName(@PathVariable(value = "id") String name) {
    List<Customer> lastnames = customerRepository.findByLastName(name);
    String response = lastnames.stream().map(lastname -> lastname.toString()).reduce("", (a, b) -> a + b);
    return response;
  }

  @PostMapping("/customer")
  public String insertCustomer(@RequestBody Customer customer){
    return customerRepository.save(customer).toString();
  }
}