package com.example.repository;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepo implements ICustomerRepo {
    private static final List<Customer> customers = new ArrayList<>();
    static {
        customers.add(new Customer(1L, "Nguyen Khac Nhat", "nhat@codegym.vn", "Hà Nội"));
        customers.add(new Customer(2L, "Dang Huy Hoa", "hoa.dang@codegym.vn", "Đà Nẵng"));
        customers.add(new Customer(3L, "Nguyen Thuy Duong", "duong.nguyen@codegym.vn", "Sài Gòn"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void save(Customer customer) {
        Customer c = findById(customer.getId());
        c.setName(customer.getName());
        c.setEmail(customer.getEmail());
        c.setAddress(customer.getAddress());
    }
}
