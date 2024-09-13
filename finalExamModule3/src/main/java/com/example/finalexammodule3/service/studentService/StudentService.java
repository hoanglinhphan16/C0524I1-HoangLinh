package com.example.finalexammodule3.service.studentService;

import com.example.finalexammodule3.model.Student;
import com.example.finalexammodule3.repository.studentRepo.IStudentRepo;
import com.example.finalexammodule3.repository.studentRepo.StudentRepo;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepo studentRepo = new StudentRepo();
    @Override
    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }
}
