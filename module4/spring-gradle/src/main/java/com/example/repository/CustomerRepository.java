package com.example.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.model.Customer;

public class CustomerRepository {
    public static List<Customer> customers = new ArrayList<>();

    static {
        Customer customer1 = new Customer(1, "HoangLinh", "hoanglinhphan16@gmail.com", "72 Me Suot");
        Customer customer2 = new Customer(2, "HoangLinh", "hoanglinhphan16@gmail.com", "72 Me Suot");
        Customer customer3 = new Customer(3, "HoangLinh", "hoanglinhphan16@gmail.com", "72 Me Suot");
        Customer customer4 = new Customer(4, "HoangLinh", "hoanglinhphan16@gmail.com", "72 Me Suot");
        Customer customer5 = new Customer(5, "HoangLinh", "hoanglinhphan16@gmail.com", "72 Me Suot");

        customers.addAll(Arrays.asList(customer1, customer2, customer3, customer4, customer5));
    }
    public List<Customer> findAll() {
        return customers;
    }
}
