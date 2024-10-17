package com.example.pigmanage.repository;

import com.example.pigmanage.model.Origin;
import com.example.pigmanage.model.Pig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPigRepository extends JpaRepository<Pig, Long> {
    @Query("select p from Pig p where p.weightIn <> p.weightOut and p.id = :id and p.origin = :origin")
    List<Pig> findAllSoldPig(@Param("id") Long id, @Param("origin") Origin origin);

    @Query("select p from Pig p where p.weightIn = p.weightOut and p.id = :id and p.origin = :origin")
    List<Pig> findAllPigNotSell(@Param("id") Long id, @Param("origin") Origin origin);

    @Query("SELECT p FROM Pig p WHERE "
            + "(:id IS NULL OR p.id = :id) "
            + "AND (:origin IS NULL OR p.origin = :origin) "
            + "AND (:status IS NULL OR "
            + "(CASE WHEN p.weightIn = p.weightOut THEN 'Chưa bán' ELSE 'Đã bán' END) = :status)")
    List<Pig> searchPig(@Param("id") Long id,
                        @Param("origin") Origin origin,
                        @Param("status") String status);
}
