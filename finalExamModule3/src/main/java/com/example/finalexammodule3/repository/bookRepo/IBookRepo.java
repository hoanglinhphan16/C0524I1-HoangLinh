package com.example.finalexammodule3.repository.bookRepo;

import com.example.finalexammodule3.model.Book;

import java.util.List;

public interface IBookRepo {
    List<Book> getAllBooks();
    Book getBookById(String id);
}
