package com.example.aopbook.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Log {
    private int count = 0;

    @After(value = "execution(* com.example.aopbook.controller.BookController.getBooks(..))")
    public void countAccess() {
        count++;
        System.out.println("----------------------------------------------");
        System.out.println("Số lần truy cập vào trang web: " + count);
    }

    @After(value = "execution(* com.example.aopbook.service.BookService.*(..))")
    public void viewChangeBook(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("Trạng thái của sách thay đổi: %s.%s%s", className, methodName, args);
    }

    @After(value = "execution(* com.example.aopbook.service.BorrowedBookService.*(..))")
    public void viewChangeBorrowedBook(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("Trạng thái của sách thay đổi: %s.%s%s", className, methodName, args);
    }
}
