package com.example.pigmanage.service;

import com.example.pigmanage.model.Origin;
import com.example.pigmanage.model.Pig;
import com.example.pigmanage.repository.IPigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PigService implements IPigService {
    @Autowired
    private IPigRepository pigRepository;

    @Override
    public List<Pig> findAll() {
        return pigRepository.findAll();
    }

    @Override
    public Pig findById(Long id) {
        return pigRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Pig pig) {
        pigRepository.save(pig);
    }

    @Override
    public List<Pig> findAllPigNotSell(Long id, Origin origin) {
        return pigRepository.findAllPigNotSell(id, origin);
    }

    @Override
    public List<Pig> findAllSoldPig(Long id, Origin origin) {
        return pigRepository.findAllSoldPig(id, origin);
    }

    @Override
    public List<Pig> searchPig(Long id, Origin origin, String status) {
        return pigRepository.searchPig(id, origin, status);
    }
}
