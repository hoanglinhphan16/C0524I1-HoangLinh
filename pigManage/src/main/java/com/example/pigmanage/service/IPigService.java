package com.example.pigmanage.service;

import com.example.pigmanage.model.Origin;
import com.example.pigmanage.model.Pig;

import java.util.List;

public interface IPigService {
    List<Pig> findAll();
    Pig findById(Long id);
    void save(Pig pig);
    List<Pig> findAllPigNotSell(Long id, Origin origin);
    List<Pig> findAllSoldPig(Long id, Origin origin);
    List<Pig> searchPig(Long id, Origin origin, String status);
}
