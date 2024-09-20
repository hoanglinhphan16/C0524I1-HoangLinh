package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    static List<Product> products = new ArrayList<Product>();

    static {
        products.add(new Product(1, "Computer", 1500.0));
        products.add(new Product(2, "Laptop", 2500.0));
        products.add(new Product(3, "Desk", 500.0));
        products.add(new Product(4, "Phone", 3500.0));
        System.out.println(products);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        product.setId(id);
        save(product);
    }

    @Override
    public void remove(int id) {
        products.remove(findById(id));
    }
}
