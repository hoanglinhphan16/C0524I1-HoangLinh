package ManageCodeGym.repository.student_repo;

import ManageCodeGym.model.Student;

import java.time.LocalDate;

public class StudentRepository implements IStudentRepository{
    private static final Student[] list;
    static {
        list = new Student[5];
        Student std1 = new Student("Hoang Linh", LocalDate.parse("1999-06-01"), "hoanglinhphan16@gmail.com", "0905089207", "C05");
        Student std2 = new Student("Linh Phan", LocalDate.parse("1999-01-06"), "luckyfarming16@gmail.com", "0559072642", "C05");
        list[0] = std1;
        list[1] = std2;
    }

    @Override
    public Student[] findAll() {
        return list;
    }
}
