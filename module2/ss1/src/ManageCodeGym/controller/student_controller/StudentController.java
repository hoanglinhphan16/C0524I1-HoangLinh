package ManageCodeGym.controller.student_controller;

import ManageCodeGym.model.Student;
import ManageCodeGym.service.student_service.IStudentService;
import ManageCodeGym.service.student_service.StudentService;

import java.util.Scanner;

public class StudentController {
    private IStudentService studentService = new StudentService();

    public void displayAllStudents() {
        Student[] students = studentService.findAll();
        for (Student student : students) {
            if (student!= null) {
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

    public void displayStudentFunc(){
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
                    break;
                case 3:
                    System.out.println("Chỉnh sửa học viên");
                    break;
                case 4:
                    System.out.println("Xoá học viên");
                    break;
                case 5:
                    return;
            }
        } while (true);
    }
}
