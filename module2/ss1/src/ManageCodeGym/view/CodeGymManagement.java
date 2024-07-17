package ManageCodeGym.view;

import ManageCodeGym.controller.student_controller.StudentController;
import ManageCodeGym.controller.teacher_controller.TeacherController;

import java.util.Scanner;

public class CodeGymManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        StudentController studentController = new StudentController();
        TeacherController teacherController = new TeacherController();

        do {
            System.out.println("Quản lý codegym: \n" +
                    "1. Quản lý học viên \n" +
                    "2. Quản lý giảng viên \n" +
                    "3. Exit");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Quản lý học viên");
                    studentController.displayStudentFunc();
                    break;
                case 2:
                    System.out.println("Quản lý giảng viên");
                    teacherController.displayTeachertFunc();
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
}
