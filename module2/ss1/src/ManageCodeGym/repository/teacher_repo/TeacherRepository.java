package ManageCodeGym.repository.teacher_repo;

import ManageCodeGym.model.Teacher;

import java.time.LocalDate;

public class TeacherRepository implements ITeacherRepository{
    private static final Teacher[] list;

    static {
        list = new Teacher[5];
        Teacher teacher1 = new Teacher("Quynh Nhu", LocalDate.parse("1999-06-01"), "hoanglinhphan16@gmail.com", "0905089207", "Master");
        Teacher teacher2 = new Teacher("Nhu Quynh", LocalDate.parse("1999-01-06"), "luckyfarming16@gmail.com", "0559072642", "Professor");
        list[0] = teacher1;
        list[1] = teacher2;
    }
    @Override
    public Teacher[] findAll() {
        return list;
    }
}
