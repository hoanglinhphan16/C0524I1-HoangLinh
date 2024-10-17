package com.example.pigmanage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;

    private Float weightIn;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;

    private Float weightOut;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Origin origin;

    private String status;

}
