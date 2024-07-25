package ss15_exception.bai_tap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter length a");
            int a = sc.nextInt();
            System.out.println("Enter length b");
            int b = sc.nextInt();
            System.out.println("Enter length c");
            int c = sc.nextInt();
            checkTriangle(a,b,c);
        }catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        };
    }

    public static void checkTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Invalid triangle");
        } else if (a + b <= c || b + c <= a || c + a <= b) {
            throw new IllegalTriangleException("Invalid triangle");
        }
    }
}
