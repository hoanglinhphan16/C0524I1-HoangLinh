package com.example.aopbook.repository;

import com.example.aopbook.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
}
