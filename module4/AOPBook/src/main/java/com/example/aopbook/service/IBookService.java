package com.example.aopbook.service;

import com.example.aopbook.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Long id);
    void save(Book book);
}
