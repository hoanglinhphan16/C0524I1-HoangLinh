package ManageCodeGym.service.teach_service;

import ManageCodeGym.model.Teacher;

import java.util.ArrayList;

public interface ITeacherService {
    ArrayList<Teacher> findAll();
    void add(Teacher teacher);
    void update(int index, Teacher teacher);
    void delete(int index);
}
