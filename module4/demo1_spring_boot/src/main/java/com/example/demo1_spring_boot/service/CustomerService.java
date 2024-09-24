package com.example.demo1_spring_boot.service;

import com.example.demo1_spring_boot.model.Customer;
import com.example.demo1_spring_boot.model.Province;
import com.example.demo1_spring_boot.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAllByProvince(Province province) {
        return iCustomerRepository.findAllByProvince(province);
    }
}
