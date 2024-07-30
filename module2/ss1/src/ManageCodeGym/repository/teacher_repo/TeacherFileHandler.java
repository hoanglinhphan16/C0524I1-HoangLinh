package ManageCodeGym.repository.teacher_repo;

import ManageCodeGym.model.Teacher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherFileHandler {
    private static final String FILE_PATH="teachers.csv";
    public static List<Teacher> readTeachersFromFile() {
        List<Teacher> teachers = new ArrayList<Teacher>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            for (String line : lines) {
                teachers.add(Teacher.fromCSVRow(line));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public static void writeTeachersToFile(List<Teacher> teachers) {
        List<String> lines = teachers.stream()
                                     .map(Teacher::toCSVRow)
                                     .collect(Collectors.toList());
        try {
            Files.write(Paths.get(FILE_PATH), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeTeacherToFile(Teacher teacher) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(teacher.toCSVRow());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
