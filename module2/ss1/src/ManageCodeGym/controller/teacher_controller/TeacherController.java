package ManageCodeGym.controller.teacher_controller;

import ManageCodeGym.model.Teacher;
import ManageCodeGym.service.teach_service.ITeacherService;
import ManageCodeGym.service.teach_service.TeacherService;

import java.time.LocalDate;
import java.util.Scanner;

public class TeacherController {
    private ITeacherService teacherService = new TeacherService();

    public void displayAllTeachers() {
        for (Teacher t : teacherService.findAll()) {
            if (t != null) {
                System.out.println(t);
            }
        }
    }

    public void displayTeachertFunc(){
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Quản lý codegym: \n" +
                    "1. Hiển thị danh sách \n" +
                    "2. Thêm mới \n" +
                    "3. Chỉnh sửa \n" +
                    "4. Xoá \n" +
                    "5. Trở về trang chủ");

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
                    return;
            }
        } while (true);
    }

    public void addTeacher() {
        Teacher teacher = scanInputOfTeacher();
        teacherService.add(teacher);
    }

    public Teacher scanInputOfTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter teacher name: ");
        String name = scanner.nextLine();
        System.out.println("Enter teacher birth date: ");
        String temp = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(temp);
        System.out.println("Enter teacher email: ");
        String email = scanner.nextLine();
        System.out.println("Enter teacher phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter teacher level: ");
        String level = scanner.nextLine();

        return new Teacher(name, birthDate, email, phoneNumber, level);
    }

    public void updateTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter index you want to update: ");
        int index = Integer.parseInt(scanner.nextLine());

        Teacher teacher = scanInputOfTeacher();
        teacherService.update(index, teacher);
    }

    public void deleteTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter index you want to delete: ");
        int index = Integer.parseInt(scanner.nextLine());

        teacherService.delete(index);
    }
}
