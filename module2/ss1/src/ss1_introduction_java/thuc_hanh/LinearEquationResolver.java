package ss1_introduction_java.thuc_hanh;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào a:");
        double a = scanner.nextDouble();
        System.out.println("Nhập vào b:");
        double b = scanner.nextDouble();
        System.out.println("Nhập vào c:");
        double c = scanner.nextDouble();

        if (a != 0) {
            double x = (c-b)/a;
            System.out.println("X: " + x);
        } else {
            if (b == c) {
                System.out.println("Pt vo so nghiem");
            } else System.out.println("Pt ko co nghiem");
        }


    }
}
