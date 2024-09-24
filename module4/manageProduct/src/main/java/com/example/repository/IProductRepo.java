package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepo extends IGenerateRepository<Product>{
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void remove(int id);
}
