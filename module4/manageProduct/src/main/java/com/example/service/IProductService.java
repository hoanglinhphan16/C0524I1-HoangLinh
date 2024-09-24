package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService extends IGenerateService<Product> {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void remove(int id);
}
