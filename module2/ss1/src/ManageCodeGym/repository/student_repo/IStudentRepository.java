package ManageCodeGym.repository.student_repo;


import ManageCodeGym.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void add(Student student);
    void update(int index, Student student);
    void remove(Student student);
}
