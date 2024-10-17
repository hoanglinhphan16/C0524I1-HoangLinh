package com.example.pigmanage.service;

import com.example.pigmanage.model.Origin;
import com.example.pigmanage.repository.IOriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginService implements IOriginService {
    @Autowired
    private IOriginRepository originRepository;

    @Override
    public List<Origin> findAll() {
        return originRepository.findAll();
    }

    @Override
    public Origin findById(Long id) {
        return originRepository.findById(id).get();
    }
}
