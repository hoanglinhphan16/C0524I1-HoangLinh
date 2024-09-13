package com.example.finalexammodule3.repository.studentRepo;

import com.example.finalexammodule3.model.Student;

import java.util.List;

public interface IStudentRepo {
    List<Student> getAllStudents();
    Student getStudentById(String id);
}
