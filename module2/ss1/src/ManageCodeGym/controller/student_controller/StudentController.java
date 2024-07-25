package ManageCodeGym.controller.student_controller;

import ManageCodeGym.model.Student;
import ManageCodeGym.service.student_service.IStudentService;
import ManageCodeGym.service.student_service.StudentService;

import java.time.DateTimeException;
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
        int choice = -1;
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
        int index = -1;
        boolean check = false;

        for (Student student : students) {
            if (student.getId() == id) {
                check = true;
                index = students.indexOf(student);
                break;
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
        for (Student student : students) {
            if (student.getId() == id) {

                studentService.remove(student);
                break;
            }
        }
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        boolean isExist;
        int id;

        do {
            System.out.println("Enter student ID: ");
            id = Integer.parseInt(scanner.nextLine());
            isExist = false;
            for (Student student : students) {
                if (student.getId() == id) {
                    System.out.println("Student already exist");
                    isExist = true;
                    break;
                }
            }
        } while (isExist);
        Student student = scanInputOfStudent(id);
        studentService.add(student);
    }

    public Student scanInputOfStudent(int id) {
        LocalDate birthDate = null;
        boolean checkFormat;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        do {
            try {
                checkFormat = false;
                System.out.println("Enter student birth date: ");
                String temp = scanner.nextLine();
                birthDate = LocalDate.parse(temp);
            } catch (DateTimeException err) {
                checkFormat = true;
                System.out.println("Wrong format");
            }
        } while (checkFormat);

        System.out.println("Enter student email: ");
        String email = scanner.nextLine();
        System.out.println("Enter student phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter student class name: ");
        String className = scanner.nextLine();

        return new Student(id, name, birthDate, email, phoneNumber, className);
    }
}
