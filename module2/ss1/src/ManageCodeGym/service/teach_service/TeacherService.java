package ManageCodeGym.service.teach_service;

import ManageCodeGym.model.Teacher;
import ManageCodeGym.repository.teacher_repo.ITeacherRepository;
import ManageCodeGym.repository.teacher_repo.TeacherRepository;

public class TeacherService implements ITeacherService {
    private ITeacherRepository teacherRepo = new TeacherRepository();


    @Override
    public Teacher[] findAll() {
        return teacherRepo.findAll();
    }
}
