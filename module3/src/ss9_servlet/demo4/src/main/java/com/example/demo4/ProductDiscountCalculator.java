package com.example.demo4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountCalculator", value = "/display-discount")
public class ProductDiscountCalculator extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDetail = request.getParameter("productDetail");
        double listPrice = Double.parseDouble(request.getParameter("listPrice"));
        double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));
        PrintWriter writer = response.getWriter();

        writer.println("Product description: " + productDetail);
        writer.println("ListPrice: " + listPrice);
        writer.println("DiscountPercent: " + discountPercent);

        double discountAmount = listPrice*discountPercent*0.01;
        double discountPrice = listPrice - discountAmount;
        writer.println("Discount amount = " + discountAmount);
        writer.println("Discount price = " + discountPrice);
    }
}
