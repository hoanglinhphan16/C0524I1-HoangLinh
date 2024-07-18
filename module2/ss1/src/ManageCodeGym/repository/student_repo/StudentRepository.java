package ManageCodeGym.repository.student_repo;

import ManageCodeGym.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentRepository implements IStudentRepository{
    private static ArrayList<Student> students = new ArrayList<>();
    static {
        students.add(new Student("Hoang Linh", LocalDate.parse("1999-06-01"), "hoanglinhphan16@gmail.com", "0905089207", "C05"));
        students.add(new Student("Linh Phan", LocalDate.parse("1999-06-01"), "luckyfarming16@gmail.com", "0905089207", "C05"));
    }

    @Override
    public ArrayList<Student> findAll() {
        return students;
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void update(int index, Student student) {
        students.set(index, student);
    }

    @Override
    public void remove(int index) {
        students.remove(index);
    }
}
