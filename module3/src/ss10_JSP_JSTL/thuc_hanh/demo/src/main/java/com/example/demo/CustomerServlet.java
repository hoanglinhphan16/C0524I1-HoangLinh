package com.example.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "customerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Nguyen Van A", "1990-01-01", "Hanoi", "https://as2.ftcdn.net/v2/jpg/07/08/47/75/1000_F_708477508_DNkzRIsNFgibgCJ6KoTgJjjRZNJD4mb4.jpg"));
        customers.add(new Customer("Tran Thi B", "1992-05-12", "Ho Chi Minh", "https://as2.ftcdn.net/v2/jpg/07/08/47/75/1000_F_708477508_DNkzRIsNFgibgCJ6KoTgJjjRZNJD4mb4.jpg"));
        customers.add(new Customer("Le Van C", "1988-11-21", "Da Nang", "https://as2.ftcdn.net/v2/jpg/07/08/47/75/1000_F_708477508_DNkzRIsNFgibgCJ6KoTgJjjRZNJD4mb4.jpg"));

        request.setAttribute("customers", customers);
        request.getRequestDispatcher("/customers.jsp").forward(request, response);
    }
}