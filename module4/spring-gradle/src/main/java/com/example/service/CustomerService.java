package com.example.service;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;

import java.util.List;

public class CustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
