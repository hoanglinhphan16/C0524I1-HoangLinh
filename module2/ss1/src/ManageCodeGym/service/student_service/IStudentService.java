package ManageCodeGym.service.student_service;

import ManageCodeGym.model.Student;

import java.util.ArrayList;

public interface IStudentService {
    ArrayList<Student> findAll();
    void add(Student student);
    void update(int index, Student student);
    void remove(Student student);
}
