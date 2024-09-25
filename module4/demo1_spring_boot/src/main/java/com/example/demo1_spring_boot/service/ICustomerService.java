package com.example.demo1_spring_boot.service;

import com.example.demo1_spring_boot.model.Customer;
import com.example.demo1_spring_boot.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Customer findById(Long id);

    void remove(Long id);

    List<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByName(Pageable pageable, String name);
}
