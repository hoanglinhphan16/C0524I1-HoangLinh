package com.example.service;

import com.example.model.Customer;
import com.example.repository.CustomerRepo;
import com.example.repository.ICustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private ICustomerRepo customerRepo = new CustomerRepo();

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }
}
