package com.example.demo1_spring_boot.repository;

import com.example.demo1_spring_boot.model.Customer;
import com.example.demo1_spring_boot.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(Pageable pageable, String name);
}
