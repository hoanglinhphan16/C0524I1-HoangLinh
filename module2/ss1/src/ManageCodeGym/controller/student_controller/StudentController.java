package ManageCodeGym.controller.student_controller;

import ManageCodeGym.model.Student;
import ManageCodeGym.service.student_service.IStudentService;
import ManageCodeGym.service.student_service.StudentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
    private IStudentService studentService = new StudentService();
    ArrayList<Student> students = studentService.findAll();

    public void displayAllStudents() {
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
                    "5. Tìm kiếm học viên \n" +
                    "6. Sắp xếp danh sách \n" +
                    "7. Trở về trang chủ");

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
                    System.out.println("Tìm kiếm học viên");
                    searchStudent();
                    break;
                case 6:
                    System.out.println("Sắp xếp danh sách\n" +
                            "1. Sắp xếp theo tên \n" +
                            "2. Sắp xếp theo ID \n" +
                            "3. Trở về");

                    int choice2 = Integer.parseInt(sc.nextLine());
                    switch (choice2) {
                        case 1:
                            sortByName();
                            break;
                        case 2:
                            sortById();
                            break;
                        case 3:
                            return;
                    }
                    break;
                case 8:
                    return;
            }
        } while (true);
    }

    public void sortByName() {
        ArrayList<Student> listStudents = (ArrayList<Student>) students.clone();
        listStudents.sort((std1, std2) -> std1.getName().compareTo(std2.getName()));
        for (Student student : listStudents) {
            System.out.println(student);
        }
    }

    public void sortById() {
        ArrayList<Student> listStudents = (ArrayList<Student>) students.clone();
        listStudents.sort((std1, std2) -> std1.getId() - std2.getId());
        listStudents.forEach(System.out::println);
    }

    public void searchStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên học viên muốn tìm");
        String name = sc.nextLine();

        students.forEach(student -> {
            if (student.getName().toLowerCase().contains(name)) {
                System.out.println(student);
            }
        });
    }

    public void updateStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID you want to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = 0;
        boolean check = false;

        for (Student student : students) {
            if (student.getId() == id) {
                check = true;
                index = students.indexOf(student);
            }
        }
        if (check) {
            Student student = scanInputOfStudent(id);
            studentService.update(index, student);
        } else System.out.println("Wrong ID");
    }

    public void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID of Student: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        int index = 0;
        for (Student student : students) {
            if (student.getId() == id) {
//                check = true;
//                index = students.indexOf(student);
                studentService.remove(student);
                break;
            }
        }
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = scanInputOfStudent(id);
        studentService.add(student);
    }

    public Student scanInputOfStudent(int id) {
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

        return new Student(id, name, birthDate, email, phoneNumber, className);
    }
}
