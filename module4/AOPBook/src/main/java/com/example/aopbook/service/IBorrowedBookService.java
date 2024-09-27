package com.example.aopbook.service;

import com.example.aopbook.model.Book;
import com.example.aopbook.model.BorrowedBook;

import java.util.List;

public interface IBorrowedBookService {
    List<BorrowedBook> findAll();
    void save(BorrowedBook borrowedBook);
    void delete(BorrowedBook borrowedBook);
    BorrowedBook findById(Long id);
}
