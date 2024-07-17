package ManageCodeGym.controller.teacher_controller;

import ManageCodeGym.model.Teacher;
import ManageCodeGym.service.teach_service.ITeacherService;
import ManageCodeGym.service.teach_service.TeacherService;

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
                    break;
                case 3:
                    System.out.println("Chỉnh sửa");
                    break;
                case 4:
                    System.out.println("Xoá");
                    break;
                case 5:
                    return;
            }
        } while (true);
    }
}
