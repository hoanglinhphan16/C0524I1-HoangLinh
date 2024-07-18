package ManageCodeGym.repository.teacher_repo;

import ManageCodeGym.model.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;

public class TeacherRepository implements ITeacherRepository{
    private static final ArrayList<Teacher> teachers = new ArrayList<>();

    static {
        Teacher teacher1 = new Teacher("Quynh Nhu", LocalDate.parse("1999-06-01"), "hoanglinhphan16@gmail.com", "0905089207", "Master");
        Teacher teacher2 = new Teacher("Nhu Quynh", LocalDate.parse("1999-01-06"), "luckyfarming16@gmail.com", "0559072642", "Professor");

        teachers.add(teacher1);
        teachers.add(teacher2);
    }
    @Override
    public ArrayList<Teacher> findAll() {
        return teachers;
    }

    @Override
    public void add(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public void update(int index, Teacher teacher) {
        teachers.set(index, teacher);
    }

    @Override
    public void delete(int index) {
        teachers.remove(index);
    }


}
