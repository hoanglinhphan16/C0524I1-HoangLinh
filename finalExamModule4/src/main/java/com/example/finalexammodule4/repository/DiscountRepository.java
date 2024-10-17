package com.example.finalexammodule4.repository;

import com.example.finalexammodule4.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    @Query("SELECT d FROM Discount d WHERE "
            + "(:startDate IS NULL OR d.startDate = :startDate) "
            + "AND (:endDate IS NULL OR d.endDate = :endDate) "
            + "AND (:discountPrice IS NULL OR d.discountPrice = :discountPrice)")
    List<Discount> searchDiscount(@Param("startDate") LocalDate startDate,
                        @Param("endDate") LocalDate endDate,
                        @Param("discountPrice") Long discountPrice);
}
