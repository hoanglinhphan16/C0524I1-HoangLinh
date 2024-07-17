package ManageCodeGym.service.student_service;

import ManageCodeGym.model.Student;
import ManageCodeGym.repository.student_repo.IStudentRepository;
import ManageCodeGym.repository.student_repo.StudentRepository;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public Student[] findAll() {
        return studentRepository.findAll();
    }
}
