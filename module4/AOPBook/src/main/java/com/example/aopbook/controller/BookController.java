package com.example.aopbook.controller;

import com.example.aopbook.model.Book;
import com.example.aopbook.model.BorrowedBook;
import com.example.aopbook.service.IBookService;
import com.example.aopbook.service.IBorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IBorrowedBookService borrowedBookService;

    @GetMapping()
    public ModelAndView getBooks() {
        ModelAndView modelAndView = new ModelAndView("listBook");
        modelAndView.addObject("books", bookService.findAll());
        return modelAndView;
    }

    @GetMapping("/borrow/{id}")
    public ModelAndView getBorrowedBook(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("book", bookService.findById(id));
        return modelAndView;
    }

    @GetMapping("/borrowedBooks")
    public ModelAndView getBorrowedBooks() {
        ModelAndView modelAndView = new ModelAndView("listBorrowedBook");
        modelAndView.addObject("borrowedBooks", borrowedBookService.findAll());
        return modelAndView;
    }

    @GetMapping("/borrowedBooks/{id}")
    public String returnBorrowedBook(@PathVariable(name = "id") Long id, RedirectAttributes redirectAttributes) {
        BorrowedBook borrowedBook = borrowedBookService.findById(id);
        Book book = borrowedBook.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookService.save(book);
        borrowedBookService.delete(borrowedBook);

        return "redirect:/books/borrowedBooks";
    }

    @PostMapping("/borrow/{id}")
    public String borrowBook(@PathVariable(name = "id") Long id, RedirectAttributes redirectAttributes) {
        Book book = bookService.findById(id);
        if (book.getQuantity() == 0) {
               return "error";
        } else {
            book.setQuantity(book.getQuantity() - 1);
            bookService.save(book);
            BorrowedBook borrowedBook = new BorrowedBook();
            borrowedBook.setBook(book);
            borrowedBookService.save(borrowedBook);
        }
        return "redirect:/books";
    }
}
