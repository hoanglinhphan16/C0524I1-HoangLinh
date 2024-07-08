package ss1_introduction_java.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chieu dai");
        width = scanner.nextFloat();

        System.out.println("Nhap chieu rong");
        height = scanner.nextFloat();

        float area = width * height;
        System.out.println("Area is " + area);
    }

}
