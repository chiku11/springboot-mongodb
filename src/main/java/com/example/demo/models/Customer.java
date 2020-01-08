package com.example.demo.models;

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    private String customerRecord = "Customer[id=%s, firstName='%s', lastName='%s']";

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString(){
        return String.format(customerRecord, id, firstName, lastName);
    }
}