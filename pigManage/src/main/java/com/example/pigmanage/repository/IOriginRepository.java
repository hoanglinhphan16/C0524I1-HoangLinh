package com.example.pigmanage.repository;

import com.example.pigmanage.model.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOriginRepository extends JpaRepository<Origin, Long> {
}
