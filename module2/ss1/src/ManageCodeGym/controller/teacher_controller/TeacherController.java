package ManageCodeGym.controller.teacher_controller;

import ManageCodeGym.model.Student;
import ManageCodeGym.model.Teacher;
import ManageCodeGym.service.teach_service.ITeacherService;
import ManageCodeGym.service.teach_service.TeacherService;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TeacherController {
    private final ITeacherService teacherService = new TeacherService();
    ArrayList<Teacher> teachers = teacherService.findAll();

    public void displayAllTeachers() {
        for (Teacher t : teachers) {
            if (t != null) {
                System.out.println(t);
            }
        }
    }

    public void displayTeachertFunc() {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Quản lý codegym: \n" +
                    "1. Hiển thị danh sách \n" +
                    "2. Thêm mới \n" +
                    "3. Chỉnh sửa \n" +
                    "4. Xoá \n" +
                    "5. Tìm kiếm giảng viên \n" +
                    "6. Sắp xếp danh sách \n" +
                    "7. Trở về trang chủ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Danh sách giảng viên:");
                    displayAllTeachers();
                    break;
                case 2:
                    System.out.println("Thêm");
                    addTeacher();
                    break;
                case 3:
                    System.out.println("Chỉnh sửa");
                    updateTeacher();
                    break;
                case 4:
                    System.out.println("Xoá");
                    deleteTeacher();
                    break;
                case 5:
                    System.out.println("Tìm kiếm giảng viên");
                    searchTeacher();
                case 6:
                    System.out.println("Bạn muốn sắp xếp theo gì?: \n" +
                            "1. Theo tên \n" +
                            "2. Theo ID \n" +
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

                case 7:
                    return;
            }
        } while (true);
    }

    public void sortByName() {
        ArrayList<Teacher> listTeacher = teachers;
        listTeacher.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        listTeacher.forEach(System.out::println);
    }

    public void sortById() {
        ArrayList<Teacher> listTeacher = teachers;
        listTeacher.sort((a, b) -> a.getId() - b.getId());
        listTeacher.forEach(System.out::println);
    }

    public void searchTeacher() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên giảng viên");
        String name = sc.nextLine();

        teachers.forEach(teacher -> {
            if (teacher.getName().toLowerCase().contains(name)) {
                System.out.println(teacher);
            }
        });
    }

    public void addTeacher() {
        Scanner scanner = new Scanner(System.in);
        boolean isExist;
        int id;

        do {
            System.out.println("Enter student ID: ");
            id = Integer.parseInt(scanner.nextLine());
            isExist = false;
            for (Teacher teacher : teachers) {
                if (teacher.getId() == id) {
                    System.out.println("Student already exist");
                    isExist = true;
                    break;
                }
            }
        } while (isExist);

        Teacher teacher = scanInputOfTeacher(id);
        teacherService.add(teacher);
    }

    public Teacher scanInputOfTeacher(int id) {
        boolean checkFormat;
        LocalDate birthDate = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter teacher name: ");
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

        System.out.println("Enter teacher email: ");
        String email = scanner.nextLine();
        System.out.println("Enter teacher phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter teacher level: ");
        String level = scanner.nextLine();

        return new Teacher(id, name, birthDate, email, phoneNumber, level);
    }

    public void updateTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID you want to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = 0;
        boolean check = false;

        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                check = true;
                index = teachers.indexOf(teacher);
            }
        }
        if (check) {
            Teacher teacher = scanInputOfTeacher(id);
            teacherService.update(index, teacher);
        } else System.out.println("Wrong ID");
    }

    public void deleteTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID of teacher: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                teachers.remove(teacher);
                break;
            }
        }
    }
}
