package ManageCodeGym.repository.student_repo;


import ManageCodeGym.model.Student;

import java.util.ArrayList;

public interface IStudentRepository {
    ArrayList<Student> findAll();
    void add(Student student);
    void update(int index, Student student);
    void remove(Student student);
}
