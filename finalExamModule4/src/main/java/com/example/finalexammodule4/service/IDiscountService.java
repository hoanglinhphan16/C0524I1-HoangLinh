package com.example.finalexammodule4.service;

import com.example.finalexammodule4.model.Discount;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface IDiscountService{
    List<Discount> findAll();
    Discount findById(Long id);
    void save(Discount discount);
    void deleteById(Long id);
    List<Discount> searchDiscount(LocalDate startDate, LocalDate endDate, Long discountPrice);
}
