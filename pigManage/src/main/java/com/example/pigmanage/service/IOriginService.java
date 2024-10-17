package com.example.pigmanage.service;

import com.example.pigmanage.model.Origin;

import java.util.List;

public interface IOriginService {
    List<Origin> findAll();
    Origin findById(Long id);
}
