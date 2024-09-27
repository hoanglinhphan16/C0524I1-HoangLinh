package com.example.aopbook.service;

import com.example.aopbook.model.Book;
import com.example.aopbook.model.BorrowedBook;
import com.example.aopbook.repository.IBorrowedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedBookService implements IBorrowedBookService{
    @Autowired
    private IBorrowedBookRepository borrowedBookRepository;

    @Override
    public List<BorrowedBook> findAll() {
        return borrowedBookRepository.findAll();
    }

    @Override
    public void save(BorrowedBook borrowedBook) {
        borrowedBookRepository.save(borrowedBook);
    }

    @Override
    public void delete(BorrowedBook borrowedBook) {
        borrowedBookRepository.delete(borrowedBook);
    }

    @Override
    public BorrowedBook findById(Long id) {
        return borrowedBookRepository.findById(id).get();
    }
}
