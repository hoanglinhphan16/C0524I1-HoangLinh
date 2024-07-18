package ManageCodeGym.controller.student_controller;

import ManageCodeGym.model.Student;
import ManageCodeGym.service.student_service.IStudentService;
import ManageCodeGym.service.student_service.StudentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
    private IStudentService studentService = new StudentService();

    public void displayAllStudents() {
        ArrayList<Student> students = studentService.findAll();
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    @Override
    public String toString() {
        return "StudentController{" +
                "studentService=" + studentService +
                '}';
    }

    public void displayStudentFunc() {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Quản lý codegym: \n" +
                    "1. Hiển thị danh sách \n" +
                    "2. Thêm mới học viên \n" +
                    "3. Chỉnh sửa thông tin \n" +
                    "4. Xoá học viên \n" +
                    "5. Trở về trang chủ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Danh sách học viên");
                    displayAllStudents();
                    break;
                case 2:
                    System.out.println("Thêm học viên");
                    addStudent();
                    break;
                case 3:
                    System.out.println("Chỉnh sửa học viên");
                    updateStudent();
                    break;
                case 4:
                    System.out.println("Xoá học viên");
                    removeStudent();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    public void updateStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chọn vị trí bạn muốn sửa đổi");
        int index = Integer.parseInt(scanner.nextLine());

        Student student = scanInputOfStudent();

        studentService.update(index, student);
    }

    public void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter index of Student: ");
        int index = Integer.parseInt(scanner.nextLine());
        studentService.remove(index);
    }

    public void addStudent() {
        Student student = scanInputOfStudent();
        studentService.add(student);
    }

    public Student scanInputOfStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student birth date: ");
        String temp = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(temp);
        System.out.println("Enter student email: ");
        String email = scanner.nextLine();
        System.out.println("Enter student phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter student class name: ");
        String className = scanner.nextLine();

        return new Student(name, birthDate, email, phoneNumber, className);
    }
}
