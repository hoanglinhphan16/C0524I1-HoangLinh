package com.example.finalexammodule3.repository.studentRepo;

import com.example.finalexammodule3.model.Book;
import com.example.finalexammodule3.model.Student;
import com.example.finalexammodule3.repository.BaseRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements IStudentRepo{
    private static final String SELECT_ALL_STUDENTS = "select * from students";

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_STUDENTS);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String classStudent = resultSet.getString("class");
                students.add(new Student(id, name, classStudent));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public Student getStudentById(String id) {
        return null;
    }
}
