package com.example.aopmanagecustomer.service;

import com.example.aopmanagecustomer.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll() throws Exception;
    Customer findOne(Long id) throws Exception;
}
