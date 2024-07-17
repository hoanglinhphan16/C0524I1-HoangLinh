package ManageCodeGym.repository.student_repo;


import ManageCodeGym.model.Student;

public interface IStudentRepository {
    Student[] findAll();
}
