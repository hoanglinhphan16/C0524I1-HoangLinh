package ManageCodeGym.repository.student_repo;

import ManageCodeGym.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentRepository implements IStudentRepository{
    private static ArrayList<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1,"Hoang Linh", LocalDate.parse("1999-06-01"), "hoanglinhphan16@gmail.com", "0905089207", "C05"));
        students.add(new Student(9,"Lucky Jack", LocalDate.parse("1999-06-01"), "luckyfarming16@gmail.com", "0905089207", "C05"));
        students.add(new Student(6,"Peter Paker", LocalDate.parse("1999-06-01"), "luckyfarming99@gmail.com", "0905089207", "C05"));
        students.add(new Student(4,"An Lan", LocalDate.parse("1999-06-01"), "luckyfarming99@gmail.com", "0905089207", "C05"));
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
    public void remove(Student student) {
        students.remove(student);
    }
}
