package com.example.service;

import com.example.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);
}
