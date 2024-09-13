package com.example.finalexammodule3.controller;

import com.example.finalexammodule3.model.Book;
import com.example.finalexammodule3.model.RentCard;
import com.example.finalexammodule3.service.bookService.BookService;
import com.example.finalexammodule3.service.bookService.IBookService;
import com.example.finalexammodule3.service.rentCardService.IRentCardService;
import com.example.finalexammodule3.service.rentCardService.RentCardService;
import com.example.finalexammodule3.service.studentService.IStudentService;
import com.example.finalexammodule3.service.studentService.StudentService;

import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IBookService bookService;
    private IStudentService studentService;
    private IRentCardService rentCardService;

    public void init() {
        bookService = new BookService();
        studentService = new StudentService();
        rentCardService =  new RentCardService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "rentBook":
                    showRentForm(request, response);
                    break;
//                case "edit":
//                    showEditForm(request, response);
//                    break;
//                case "delete":
//                    deleteCategory(request, response);
//                    break;
                default:
                    listBooks(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createRentCard":
                    insertRentCard(request, response);
                    break;
//                case "edit":
//                    updateLocation(request, response);
//                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    public void listBooks(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        request.setAttribute("books", bookService.getAllBooks());
        RequestDispatcher dispatcher = request.getRequestDispatcher("listBooks.jsp");
        dispatcher.forward(request, response);
    }

    public void showRentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("bookId");
        Book book = bookService.getBookById(id);
        request.setAttribute("students", studentService.getAllStudents());
        request.setAttribute("book", book);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(new Date());
        request.setAttribute("dateNow", formattedDate);
        if (book.getQuantity() == 0) {
            request.getSession().setAttribute("message", "Lỗi! Sách này đã hết vui lòng chọn sách khác");
            request.getSession().setAttribute("status", "error");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("formRentBook.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void insertRentCard(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String bookId = request.getParameter("bookId");
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String rentDateStr = request.getParameter("rentDate");
        String returnDateStr = request.getParameter("returnDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date rentDate = null;
        java.util.Date returnDate = null;
        try {
            rentDate = dateFormat.parse(rentDateStr);
            returnDate = dateFormat.parse(returnDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (rentDate!= null & returnDate!= null) {
            RentCard rentCard = new RentCard("đang mượn", new java.sql.Date(rentDate.getTime()), new java.sql.Date(returnDate.getTime()), studentId, bookId);
            rentCardService.rentCard(rentCard);
            response.sendRedirect("/BookServlet?action=listBooks");
        }
    }
}