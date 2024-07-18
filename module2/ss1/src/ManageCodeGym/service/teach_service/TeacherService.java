package ManageCodeGym.service.teach_service;

import ManageCodeGym.model.Teacher;
import ManageCodeGym.repository.teacher_repo.ITeacherRepository;
import ManageCodeGym.repository.teacher_repo.TeacherRepository;

import java.util.ArrayList;

public class TeacherService implements ITeacherService {
    private ITeacherRepository teacherRepo = new TeacherRepository();


    @Override
    public ArrayList<Teacher> findAll() {
        return teacherRepo.findAll();
    }

    @Override
    public void add(Teacher teacher) {
        teacherRepo.add(teacher);
    }

    @Override
    public void update(int index, Teacher teacher) {
        teacherRepo.update(index, teacher);
    }

    @Override
    public void delete(int index) {
        teacherRepo.delete(index);
    }
}
