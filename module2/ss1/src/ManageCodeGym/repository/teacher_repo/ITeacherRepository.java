package ManageCodeGym.repository.teacher_repo;

import ManageCodeGym.model.Teacher;

import java.util.ArrayList;

public interface ITeacherRepository {
    ArrayList<Teacher> findAll();
    void add(Teacher teacher);
    void update(int index,Teacher teacher);
    void delete(int index);
}
