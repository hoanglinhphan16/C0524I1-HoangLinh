package ManageCodeGym.repository.student_repo;

import ManageCodeGym.model.Student;
import ManageCodeGym.util.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List students;
    private static Student studentInstance = new Student();

    static {
//                students.add(new Student(1,"Hoang Linhzz", LocalDate.parse("1999-06-01"), "hoanglinhphan16@gmail.com", "0905089207", "C05"));
//                students.add(new Student(9,"Lucky Jack", LocalDate.parse("1999-06-01"), "luckyfarming16@gmail.com", "0905089207", "C05"));
//                students.add(new Student(6,"Peter Paker", LocalDate.parse("1999-06-01"), "luckyfarming99@gmail.com", "0905089207", "C05"));
//                students.add(new Student(4,"An Lan", LocalDate.parse("1999-06-01"), "luckyfarming99@gmail.com", "0905089207", "C05"));
//        String csvFile = "students.csv";
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
//            // Write header
//            writer.write("ID,Name,Age,Email,Phone Number,Class Name");
//            writer.newLine();
//            // Write data
//            for (Student std : students) {
//                writer.write(std.toCSVRow());
//                writer.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        FileHandler<Student> studentFileHandler = new FileHandler<>(
//                "students.csv",
//                new FileHandler.CSVConvertible<>() {
//                    @Override
//                    public Student fromCSVRow(String row) {
//                        return Student.fromCSVRow(row);
//                    }
//
//                    @Override
//                    public String toCSVRow(Student student) {
//                        return student.toCSVRow();
//                    }
//                }
//        );
        students = FileHandler.readFromFile(studentInstance, "students.csv");

    }

    @Override
    public ArrayList<Student> findAll() {
        return (ArrayList<Student>) students;
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
