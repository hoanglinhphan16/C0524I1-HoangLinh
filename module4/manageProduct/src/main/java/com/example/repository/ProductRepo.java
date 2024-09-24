package com.example.repository;

import com.example.model.Product;

import java.util.List;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
@Repository
public class ProductRepo implements IProductRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        Product existingProduct = entityManager.find(Product.class, product.getId());
        if (existingProduct != null) {
            entityManager.merge(product);
        } else {
            entityManager.persist(product);
        }
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.id = :id", Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}
