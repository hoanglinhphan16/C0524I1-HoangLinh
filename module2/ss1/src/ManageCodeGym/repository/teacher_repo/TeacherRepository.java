package ManageCodeGym.repository.teacher_repo;

import ManageCodeGym.model.Teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements ITeacherRepository{
    private static List<Teacher> teachers = new ArrayList<>();

    static {
//        Teacher teacher1 = new Teacher(34,"Quynh Nhu", LocalDate.parse("1999-06-01"), "hoanglinhphan16@gmail.com", "0905089207", "Master");
//        Teacher teacher2 = new Teacher(43,"Tuan Anh", LocalDate.parse("1999-01-06"), "luckyfarming16@gmail.com", "0559072642", "Professor");
//        Teacher teacher3 = new Teacher(9,"Lan Nhi", LocalDate.parse("1999-01-06"), "luckyfarming16@gmail.com", "0559072642", "Professor");
//        Teacher teacher4 = new Teacher(11,"To Uyen", LocalDate.parse("1999-01-06"), "luckyfarming16@gmail.com", "0559072642", "Professor");
//        Teacher teacher5 = new Teacher(22,"My Huyen", LocalDate.parse("1999-01-06"), "luckyfarming16@gmail.com", "0559072642", "Professor");
//
//        teachers.add(teacher1);
//        teachers.add(teacher2);
//        teachers.add(teacher3);
//        teachers.add(teacher4);
//        teachers.add(teacher5);
//        String csvFile = "teachers.csv";
//        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//            String line = br.readLine(); //Đọc dòng tiêu đề
//            while ((line = br.readLine()) != null) {
//                Teacher teacher = Teacher.fromCSVRow(line);
//                teachers.add(teacher);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        teachers = TeacherFileHandler.readTeachersFromFile();
    }

    @Override
    public ArrayList<Teacher> findAll() {
        return (ArrayList<Teacher>) teachers;
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
    public void delete(Teacher teacher) {
        teachers.remove(teacher);
    }


}
