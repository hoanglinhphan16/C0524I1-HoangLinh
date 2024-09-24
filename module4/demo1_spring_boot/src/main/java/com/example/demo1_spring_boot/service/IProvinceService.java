package com.example.demo1_spring_boot.service;

import com.example.demo1_spring_boot.model.Province;

import java.util.List;

public interface IProvinceService {
    List<Province> findAll();

    void save(Province product);

    Province findById(Long id);

    void remove(Long id);
}
