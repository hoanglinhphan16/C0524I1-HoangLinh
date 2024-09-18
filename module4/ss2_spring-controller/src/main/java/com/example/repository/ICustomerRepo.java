package com.example.repository;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);
}