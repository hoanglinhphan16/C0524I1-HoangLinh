package com.example.finalexammodule3.service.bookService;

import com.example.finalexammodule3.model.Book;
import com.example.finalexammodule3.repository.bookRepo.BookRepo;
import com.example.finalexammodule3.repository.bookRepo.IBookRepo;

import java.util.List;

public class BookService implements IBookService{
    private IBookRepo bookRepo = new BookRepo();
    @Override
    public List<Book> getAllBooks() {
        return bookRepo.getAllBooks();
    }

    @Override
    public Book getBookById(String id) {
        return bookRepo.getBookById(id);
    }
}
