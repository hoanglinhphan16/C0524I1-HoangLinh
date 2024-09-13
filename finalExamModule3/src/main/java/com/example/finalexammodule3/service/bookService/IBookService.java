package com.example.finalexammodule3.service.bookService;

import com.example.finalexammodule3.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    Book getBookById(String id);
}
