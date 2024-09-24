package com.example.demo1_spring_boot.service;

import com.example.demo1_spring_boot.model.Customer;
import com.example.demo1_spring_boot.model.Province;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Long id);

    void remove(Long id);

    List<Customer> findAllByProvince(Province province);
}
