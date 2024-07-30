package ManageCodeGym.repository.student_repo;

import ManageCodeGym.model.Student;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentFileHandler {
    private static final String FILE_PATH = "students.csv";

    public static List<Student> readStudentsFromFile() {
        List<Student> students = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            for (String line : lines) {
                students.add(Student.fromCSVRow(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void writeStudentsToFile(List<Student> students) {
        List<String> lines = students.stream().map(Student::toCSVRow).collect(Collectors.toList());
        try {
            Files.write(Paths.get(FILE_PATH), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeStudentToFile(Student student) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(student.toCSVRow());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
