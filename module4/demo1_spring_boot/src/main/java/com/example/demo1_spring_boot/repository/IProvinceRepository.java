package com.example.demo1_spring_boot.repository;

import com.example.demo1_spring_boot.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IProvinceRepository extends JpaRepository<Province, Long> {

}