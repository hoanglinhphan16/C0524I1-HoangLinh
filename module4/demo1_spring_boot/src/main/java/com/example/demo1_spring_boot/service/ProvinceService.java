package com.example.demo1_spring_boot.service;

import com.example.demo1_spring_boot.model.Customer;
import com.example.demo1_spring_boot.model.Province;
import com.example.demo1_spring_boot.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository iProvinceRepository;


    @Override
    public List<Province> findAll() {
        return iProvinceRepository.findAll();
    }

    @Override
    public void save(Province Province) {
        iProvinceRepository.save(Province);
    }

    @Override
    public Province findById(Long id) {
        return iProvinceRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        iProvinceRepository.deleteById(id);
    }
}