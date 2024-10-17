package com.example.finalexammodule4.service;

import com.example.finalexammodule4.model.Discount;
import com.example.finalexammodule4.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DiscountService implements IDiscountService {
    @Autowired
    private DiscountRepository discountRepository;


    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public Discount findById(Long id) {
        return discountRepository.findById(id).get();
    }

    @Override
    public void save(Discount discount) {
        discountRepository.save(discount);
    }

    @Override
    public void deleteById(Long id) {
        discountRepository.deleteById(id);
    }

    @Override
    public List<Discount> searchDiscount(LocalDate startDate, LocalDate endDate, Long discountPrice) {
        return discountRepository.searchDiscount(startDate, endDate, discountPrice);
    }
}
