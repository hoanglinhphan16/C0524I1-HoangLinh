package ManageCodeGym.service.student_service;

import ManageCodeGym.model.Student;
import ManageCodeGym.repository.student_repo.IStudentRepository;
import ManageCodeGym.repository.student_repo.StudentRepository;

import java.util.ArrayList;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public ArrayList<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void add(Student student) {
        studentRepository.add(student);
    }

    @Override
    public void update(int index, Student student) {
        studentRepository.update(index, student);
    }

    @Override
    public void remove(Student student) {
        studentRepository.remove(student);
    }
}
